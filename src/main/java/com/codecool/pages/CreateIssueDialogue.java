package com.codecool.pages;

import com.codecool.util.CustomWait;
import kotlin.reflect.KAnnotatedElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIssueDialogue extends BasePage {
    private final CustomWait customWait;
    @FindBy(xpath = "//section[@id='create-issue-dialog']")
    private WebElement createIssueForm;
    @FindBy(xpath = "//section[@id='create-issue-dialog']//h2")
    private WebElement createIssueHeader;
    @FindBy(xpath = "//*[@id='project-field']")
    private WebElement projectInputField;
    @FindBy(xpath = "//*[@id='summary']")
    private WebElement projectSummary;
    @FindBy(xpath = "//*[@id='create-issue-submit']")
    private WebElement createIssueSubmitBtn;


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

    public void enterTextToProjectInputField(String text) throws InterruptedException {
        projectInputField.click();
        projectInputField.sendKeys(text);
        projectInputField.sendKeys(Keys.ENTER);
    }

    private void clearProjectSummary() {
        projectSummary.clear();
    }

    private void enterTextToProjectSummary(String text) {
        wait.until(ExpectedConditions.visibilityOf(projectSummary));
        projectSummary.clear();
        projectSummary.sendKeys(text);
    }

    public void fillCreateIssueDialogue(String id, String projectKey, String summaryText) throws InterruptedException {
        enterTextToProjectInputField(projectKey);
        customWait.waitForElementToBeInteractable(id, summaryText);
        waitAndClick(createIssueSubmitBtn);
    }

}
