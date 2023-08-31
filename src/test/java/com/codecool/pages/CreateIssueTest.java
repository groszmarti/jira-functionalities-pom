package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void issueCreationWithMandatoryFieldsShouldBeSuccessful() throws InterruptedException {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.clickCreateBtn();
        createIssueDialogue.isCreateIssueDialogueVisible();
        String expected = "Create Issue";
        Assertions.assertEquals(expected,createIssueDialogue.getCreateIssueDialogueHeaderText());
        String id = "summary";
        String projectKey = "Main";
        String summaryText = "Create new test issue";
        createIssueDialogue.fillCreateIssueDialogue(id, projectKey,summaryText);

        String popupWindowText = header.getPopupText();
        header.clickPopupWindow();
        String actualProjectId = issueSummaryPage.getprojectId();
        Assertions.assertTrue(popupWindowText.contains(actualProjectId));

        issueSummaryPage.doDeleteIssue();
    }

}
