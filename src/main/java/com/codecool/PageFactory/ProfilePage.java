package com.codecool.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (xpath = "//*[@id='up-d-username']")
    WebElement profileUserName;

    @FindBy(xpath = "//*[@id='header-details-user-fullname']//img")
    private WebElement avatarIcon;
    @FindBy (xpath = "//*[@id='log_out']")
    private WebElement logoutMenuItem;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getProfileUserName() {
        return profileUserName.getText();
    }
    public void clickAvatarIcon() {
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
        wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        avatarIcon.click();
    }
    public void clickLogoutMenuItem() {
        wait.until(ExpectedConditions.visibilityOf(logoutMenuItem));
        logoutMenuItem.click();
    }
}
