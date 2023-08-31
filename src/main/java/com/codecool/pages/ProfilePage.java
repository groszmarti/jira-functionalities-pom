package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{

    @FindBy (xpath = "//*[@id='up-d-username']")
    private WebElement profileUserName;
    @FindBy(xpath = "//*[@id='header-details-user-fullname']//img")
    private WebElement avatarIcon;
    @FindBy (xpath = "//*[@id='log_out']")
    private WebElement logoutMenuItem;

    public ProfilePage() {
        super();
    }

    public String getProfileUserName() {
        return profileUserName.getText();
    }
    public void clickAvatarIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        avatarIcon.click();
    }
    public void clickLogoutMenuItem() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutMenuItem));
        logoutMenuItem.click();
    }
    public void logOut() {
        clickAvatarIcon();
        clickLogoutMenuItem();
    }
}
