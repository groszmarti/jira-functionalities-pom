package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssueSummaryPage extends BasePage{
    @FindBy(xpath = "//*[@id='key-val']")
    WebElement projectId;
    @FindBy(xpath = "//*[@id='opsbar-operations_more']")
    WebElement moreBtn;
    @FindBy(xpath = "//*[@id='delete-issue']")
    WebElement deleteIssueMenuItem;
    @FindBy(xpath = "//*[@id='delete-issue-submit']")
    WebElement deleteIssueSubmit;
    @FindBy(xpath = "//*[@id='delete-issue-dialog']/h2")
    WebElement deleteIssueDialogue;
    @FindBy(xpath = "//div[@class='aui-message closeable aui-message-success aui-will-close']")
    WebElement deletePopupConfirmation;

    public IssueSummaryPage() {
        super();
    }

    public String getprojectId() {
        return projectId.getText();
    }
    private void clickMoreBtn() {
        moreBtn.click();
    }
    private void clickDeleteissue() {
        deleteIssueMenuItem.click();
    }
    private void clickDeleteIssueSubmit() {
        waitAndClick(deleteIssueSubmit);
    }

    public void doDeleteIssue() {
        clickMoreBtn();
        clickDeleteissue();
        clickDeleteIssueSubmit();
    }
    public String getDeleteIssueDialogueText() {
        return deleteIssueDialogue.getText();
    }
    public String getDeletePopupText() {
        return deletePopupConfirmation.getText();
    }
}
