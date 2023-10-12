package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CreateIssueTest {
    private LoginPage loginPage;
    private Header header;
    private IssueSummaryPage issueSummaryPage;
    private CreateIssueDialogue createIssueDialogue;


    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        header = new Header();
        issueSummaryPage = new IssueSummaryPage();
        createIssueDialogue = new CreateIssueDialogue();
        loginPage.navigateTo(LoginPage.LOGIN_URL);
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);

    }

    @AfterEach
    void tearDown() {
        issueSummaryPage.quitDriver();
    }

    @Test
    public void issueCreationWithMandatoryFieldsShouldBeSuccessful() throws InterruptedException {
        header.clickCreateBtn();
        String expected = "Create Issue";
        Assertions.assertEquals(expected,createIssueDialogue.getCreateIssueDialogueHeaderText());
        String summaryId = "summary";
        String issueTypeId = "issuetype-field";
        String projectKey = "Main";
        String summaryText = "Create new test issue";
        String issueType = "Task";
        createIssueDialogue.setProjectKey(projectKey);
        createIssueDialogue.setIssueTypeText(issueTypeId, issueType);
        createIssueDialogue.setSummaryText(summaryId, summaryText);
        createIssueDialogue.clickCreatIssueSubmitBtn();

        Assertions.assertTrue(header.isCreateIssueFormNotPresented());

        String popupWindowText = header.getPopupText();
        header.clickPopupWindow();
        String actualProjectId = issueSummaryPage.getprojectId();
        Assertions.assertTrue(popupWindowText.contains(actualProjectId));

        issueSummaryPage.doDeleteIssue();
    }

    @Test
    public void unsuccessfulIssueCreationWithoutSummaryMandatoryField() {
        header.clickCreateBtn();
        String expected = "Create Issue";
        Assertions.assertEquals(expected,createIssueDialogue.getCreateIssueDialogueHeaderText());
        String issueTypeId = "issuetype-field";
        String projectKey = "Main";
        String issueType = "Bug";
        createIssueDialogue.setProjectKey(projectKey);
        createIssueDialogue.setIssueTypeText(issueTypeId, issueType);
        createIssueDialogue.clickCreatIssueSubmitBtn();

        String errorMessage = createIssueDialogue.getErrorMessage();
        String expectedErrorMessage = "You must specify a summary of the issue.";
        Assertions.assertTrue(errorMessage.contains(expectedErrorMessage));

        createIssueDialogue.cancelCreateIssueDialogue();
    }
  
    @Test
    public void successfulCancelIssueCreation(){
        header.clickCreateBtn();
        createIssueDialogue.waitForCreateIssueDialogueHeaderText();
        createIssueDialogue.cancelCreateIssueDialogue();
        //validate the createIssueForm disappear
        Assertions.assertFalse(header.isCreateIssueFormNotPresented());

    }

}

