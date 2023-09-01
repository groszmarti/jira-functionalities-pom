package com.codecool.pages;

import com.codecool.util.CustomWait;
import kotlin.reflect.KAnnotatedElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement createIssueCancelBtn;
    @FindBy(xpath = "//*[id='issuetype-field']")
    private WebElement issueType;
    @FindBy(xpath = "//*[@id='assistive-text']")
    private WebElement noMatchesText;
    @FindBy(xpath = "//*[@id='issuetype-suggestions']")
    private WebElement issueTypeSelect;
    @FindBy(xpath = "//*[@id='dialog-form']//div[@class='error']")
    private WebElement errorMessageElement;

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
        projectInputField.click();
        projectInputField.sendKeys(text);
        projectInputField.sendKeys(Keys.ENTER);
    }
    /*public void enterTextToIssueTypeInputField(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(issueType));
        issueType.clear();
        issueType.sendKeys(text);
      //  customWait.waitForElementToBeInteractable("issuetype-field", text);
        issueType.sendKeys(Keys.ENTER);
    }

    private void clearProjectSummary() {
        projectSummary.clear();
    }
    public void enterTextToProjectSummary(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(projectSummary));
        projectSummary.clear();
        projectSummary.sendKeys(text);
    }*/
    public void fillCreateIssueDialogue( String projectKey, String issueTypeId, String issueTypeText, String summaryId, String summaryText) {
        enterTextToProjectInputField(projectKey);
        customWait.waitForElementToBeInteractable(issueTypeId,issueTypeText);
        customWait.waitForElementToBeInteractable(summaryId,summaryText);
        waitAndClick(createIssueSubmitBtn);
    }
    public void cancelCreateIssueDialogue() {
        waitAndClick(createIssueCancelBtn);
    }
    public void fillCreateIssueDialogueWithoutSummaryAndSubmit( String projectKey, String issueTypeId, String issueTypeText) {
        enterTextToProjectInputField(projectKey);
        customWait.waitForElementToBeInteractable(issueTypeId,issueTypeText);
    }
    public boolean IsNoMatchesTextInOptions() {
        return !noMatchesText.isDisplayed();
    }
    public int countMissingIssueTypes(List<String> expectedIssueTypes) {
        List<String> availableIssueTypes = getAvailableIssueTypes(); // Implement this function to retrieve the available issue types
        List<String> missingIssueTypes = new ArrayList<>(expectedIssueTypes);
        missingIssueTypes.removeAll(availableIssueTypes);
        return missingIssueTypes.size();
    }
    public List<String> getAvailableIssueTypes() {
        List<String> availableTypes = new ArrayList<>();
        Select select = new Select(issueTypeSelect);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            availableTypes.add(option.getText());
        }
        return availableTypes;
    }
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
        return errorMessageElement.getText();
    }
}
