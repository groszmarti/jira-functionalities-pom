package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueSummaryPage extends BasePage{
    @FindBy(xpath = "//*[@id='key-val']")
    private WebElement projectId;
    @FindBy(xpath = "//*[@id='opsbar-operations_more']")
    private WebElement moreBtn;
    @FindBy(xpath = "//*[@id='delete-issue']")
    private WebElement deleteIssueMenuItem;
    @FindBy(xpath = "//*[@id='delete-issue-submit']")
    private WebElement deleteIssueSubmit;
    @FindBy(xpath = "//*[@id='delete-issue-dialog']/h2")
    private WebElement deleteIssueDialogue;
    @FindBy(xpath = "//div[@class='aui-message closeable aui-message-success aui-will-close']")
    private WebElement deletePopupConfirmation;

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
}
