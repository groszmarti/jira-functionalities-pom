package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    WebElement createBtn;

    @FindBy(xpath = "//*[@id='aui-flag-container']/div/div/a")
    WebElement popupWindow;


    public Header() {
        super();
    }

    public WebElement getAvatarIcon() {
        return avatarIcon;
    }

    public String getAvatarParentDataUsername() {
        return avatarParent.getAttribute("data-username");
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

    public String getLoggedUserName() {
        return avatarParent.getAttribute("data-username");
    }

    public void navigateToProfilePage() {
        clickAvatarIcon();
        clickProfileMenuItem();
    }
}
