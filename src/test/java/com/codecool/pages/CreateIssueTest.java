package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

public class CreateIssueTest {
    private LoginPage loginPage;
    private Header header;
    private IssueSummaryPage issueSummaryPage;
    private CreateIssueDialogue createIssueDialogue;
    private String loginUrl;

    @BeforeEach
    void setUp() {
        loginUrl ="/secure/Dashboard.jspa";
        loginPage = new LoginPage();
        header = new Header();
        issueSummaryPage = new IssueSummaryPage();
        createIssueDialogue = new CreateIssueDialogue();
        loginPage.setDriver(loginUrl);

    }

    @AfterEach
    void tearDown() {
        issueSummaryPage.quitDriver();
    }

    @Test
    public void issueCreationWithMandatoryFieldsShouldBeSuccessful() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.clickCreateBtn();
        createIssueDialogue.isCreateIssueDialogueVisible();
        String expected = "Create Issue";
        Assertions.assertEquals(expected,createIssueDialogue.getCreateIssueDialogueHeaderText());
        String summaryId = "summary";
        String issueTypeId = "issuetype-field";
        String projectKey = "Main";
        String summaryText = "Create new test issue";
        String issueType = "Task";
        createIssueDialogue.fillCreateIssueDialogue(projectKey, issueTypeId, issueType, summaryId, summaryText);

        Assertions.assertTrue(header.isCreateIssueFormNotPresented());

        String popupWindowText = header.getPopupText();
        header.clickPopupWindow();
        String actualProjectId = issueSummaryPage.getprojectId();
        Assertions.assertTrue(popupWindowText.contains(actualProjectId));

        issueSummaryPage.doDeleteIssue();
    }

    @Test
    public void unsuccessfulIssueCreationWithoutSummaryMandatoryField() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.clickCreateBtn();
        createIssueDialogue.isCreateIssueDialogueVisible();
        String expected = "Create Issue";
        Assertions.assertEquals(expected,createIssueDialogue.getCreateIssueDialogueHeaderText());
        String summaryId = "summary";
        String issueTypeId = "issuetype-field";
        String projectKey = "Main";
        String summaryText = "";
        String issueType = "Bug";
        createIssueDialogue.fillCreateIssueDialogue(projectKey, issueTypeId, issueType, summaryId, summaryText);

        String errorMessage = createIssueDialogue.getErrorMessage();
        String expectedErrorMessage = "You must specify a summary of the issue.";
        Assertions.assertTrue(errorMessage.contains(expectedErrorMessage));

        createIssueDialogue.cancelCreateIssueDialogue();
    }
    @Test
    public void successfulCancelIssueCreation(){
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.clickCreateBtn();
        createIssueDialogue.isCreateIssueDialogueVisible();
        createIssueDialogue.cancelCreateIssueDialogue();
        //validate the createIssueForm disappear
        Assertions.assertFalse(header.isCreateIssueFormNotPresented());

    }

    //Its validate the inverse feature
    @ParameterizedTest
    @CsvFileSource(resources = "/issueTypeInProject.csv", numLinesToSkip = 1)
    public void validateIssueTypesNotExistInProjectsByIssueCreation(String projectKey, String issueTypeId, String issueText) {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.clickCreateBtn();
        createIssueDialogue.isCreateIssueDialogueVisible();
        createIssueDialogue.fillCreateIssueDialogueWithoutSummaryAndSubmit(projectKey, issueTypeId, issueText);
        Assertions.assertTrue(createIssueDialogue.IsNoMatchesTextInOptions());
    }

}

