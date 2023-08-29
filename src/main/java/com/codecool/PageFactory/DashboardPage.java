package com.codecool.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@id='header-details-user-fullname']//img")
    private WebElement avatarIcon;

    @FindBy(xpath = "//*[@id='header-details-user-fullname']")
    private WebElement avatarParent;

    @FindBy(xpath = "//a[@id='view_profile']")
    private WebElement profileMenuItem;

    @FindBy(xpath = "//*[@id='log_out']")
    private WebElement logoutMenuItem;
    @FindBy (xpath = "//a[@id='create_link']")
    WebElement createBtn;
    @FindBy (xpath = "//section[@id='create-issue-dialog']")
    WebElement createIssueForm;
    @FindBy (xpath = "//section[@id='create-issue-dialog']//h2")
    WebElement createIssueHeader;
    @FindBy(xpath = "//input[@id='project-field']")
    WebElement projectInputField;
    @FindBy(xpath = "//input[@id='summary']")
    WebElement projectSummary;
    @FindBy(xpath = "//input[@id='create-issue-submit']")
    WebElement createissueSubmitBtn;
    @FindBy(xpath = "//*[@id='aui-flag-container']/div/div/a")
    WebElement popupWindow;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement getAvatarIcon() {
        return avatarIcon;
    }

    public String getAvatarParentDataUsername() {
        return avatarParent.getAttribute("data-username");
    }
    public void clickCreateBtn() {
        createBtn.click();
    }

    public void isCreateIssueFormVisible() {
        wait.until(ExpectedConditions.visibilityOf(createIssueForm));
    }
    public String getCreateIssueFormHeaderText() {
        return createIssueHeader.getText();
    }
    public void enterTextToProjectInputField(String text) {
        projectInputField.sendKeys(text);
    }
    public void enterTextToProjectSummary(String text) {
        wait.until(ExpectedConditions.visibilityOf(projectSummary));
        projectSummary.sendKeys(text);
    }
    public void clickCreateIssueSubmitBtn() {
        createissueSubmitBtn.click();
    }
    public void clickPopupWindow() {
        wait.until(ExpectedConditions.visibilityOf(popupWindow));
        popupWindow.click();
    }
    public String getPopupText() {
        wait.until(ExpectedConditions.visibilityOf(popupWindow));
        return popupWindow.getText();
    }

    public void clickAvatarIcon() {
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
        wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        avatarIcon.click();
    }

    public void clickProfileMenuItem() {
        wait.until(ExpectedConditions.visibilityOf(profileMenuItem));
        profileMenuItem.click();
    }

    public void clickLogoutMenuItem() {
        wait.until(ExpectedConditions.visibilityOf(logoutMenuItem));
        logoutMenuItem.click();
    }

    public void isAvatarVisible() {
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
    }

    public String getLoggedUserName() {
        return avatarParent.getAttribute("data-username");
    }
}
