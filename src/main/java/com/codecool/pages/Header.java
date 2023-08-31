package com.codecool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Header extends BasePage{

    @FindBy(xpath = "//*[@id='header-details-user-fullname']//img")
    private WebElement avatarIcon;
    @FindBy(xpath = "//*[@id='header-details-user-fullname']")
    private WebElement avatarParent;
    @FindBy(xpath = "//a[@id='view_profile']")
    private WebElement profileMenuItem;
    @FindBy(xpath = "//*[@id='log_out']")
    private WebElement logoutMenuItem;
    @FindBy (xpath = "//a[@id='create_link']")
    private WebElement createBtn;
    @FindBy(xpath = "//*[@id='aui-flag-container']/div/div/a")
    private WebElement popupWindow;

    @FindAll ({
        @FindBy(xpath = "//section[@id='create-issue-dialog']")
    })
    private List<WebElement> createIssueForm;

    public Header() {
        super();
    }

    public void clickCreateBtn() {
        waitAndClick(createBtn);
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

    public void navigateToProfilePage() {
        clickAvatarIcon();
        clickProfileMenuItem();
    }

    public boolean isCreateIssueFormNotPresent() {
        if(!createIssueForm.isEmpty()){
            return true;
        }
        return false;
    }
}
