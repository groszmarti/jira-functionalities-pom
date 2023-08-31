package com.codecool.pages;

import com.codecool.util.CustomWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIssueDialogue extends BasePage {
    private CustomWait customWait;
    @FindBy(xpath = "//section[@id='create-issue-dialog']")
    WebElement createIssueForm;
    @FindBy (xpath = "//section[@id='create-issue-dialog']//h2")
    WebElement createIssueHeader;
    @FindBy(xpath = "//*[@id='project-field']")
    WebElement projectInputField;
    @FindBy(xpath = "//*[@id='summary']")
    WebElement projectSummary;
    @FindBy(xpath = "//*[@id='create-issue-submit']")
    WebElement createIssueSubmitBtn;


    public CreateIssueDialogue() {
        super();
        this.customWait = new CustomWait();
    }

    public void isCreateIssueDialogueVisible() {
        wait.until(ExpectedConditions.visibilityOf(createIssueForm));
    }
    public String getCreateIssueDialogueHeaderText() {
        return createIssueHeader.getText();
    }
    public void enterTextToProjectInputField(String text) {
        projectInputField.sendKeys(text);
    }
    public void clearProjectSummary() {
        projectSummary.clear();
    }
    public void enterTextToProjectSummary(String text) {
        wait.until(ExpectedConditions.visibilityOf(projectSummary));
        projectSummary.clear();
        projectSummary.sendKeys(text);
    }
    public void clickCreateIssueSubmitBtn() {
        createIssueSubmitBtn.click();
    }

    public void fillCreateIssueDialogue(String id, String projectKey, String summaryText) {
        enterTextToProjectInputField(projectKey);
        customWait.waitForElementToBeInteractable(id,summaryText);
        waitAndClick(createIssueSubmitBtn);
    }

}
