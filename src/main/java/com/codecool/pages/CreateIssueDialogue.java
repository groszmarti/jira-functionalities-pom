package com.codecool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIssueDialogue extends BasePage {
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

    public void fillCreateIssueDialogue(String projectKey, String summary) {

        enterTextToProjectInputField(projectKey);

        try {
            By summaryProject = By.id("summary");
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(summaryProject));
            element.click();


        } catch (TimeoutException e) {
            By summaryProject = By.id("summary");
            wait.until(ExpectedConditions.elementToBeClickable(summaryProject)).sendKeys(summary);
            System.out.println("Timeout occurred while waiting for element.");
        } catch (StaleElementReferenceException e) {
            By summaryProject = By.id("summary");
            wait.until(ExpectedConditions.elementToBeClickable(summaryProject)).sendKeys(summary);
            System.out.println("Stale element exception occurred.");
        }

        waitAndClick(createIssueSubmitBtn);
    }

}
