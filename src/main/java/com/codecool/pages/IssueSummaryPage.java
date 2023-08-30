package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssueSummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;
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

    public IssueSummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getprojectId() {
        return projectId.getText();
    }
    public void clickMoreBtn() {
        moreBtn.click();
    }
    public void clickDeleteissue() {
        deleteIssueMenuItem.click();
    }
    public void clickDeleteIssueSubmit() {
        deleteIssueSubmit.click();
    }
    public String getDeleteIssueDialogueText() {
        return deleteIssueDialogue.getText();
    }
    public String getDeletePopupText() {
        return deletePopupConfirmation.getText();
    }
}
