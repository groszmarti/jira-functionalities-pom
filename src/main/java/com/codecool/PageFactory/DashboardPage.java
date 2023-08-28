package com.codecool.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//img[@contains[@alt, 'User profile for Auto Tester']]")
    private WebElement avatarIcon;
    @FindBy(xpath = "//a[@id='view_profile']")
    private WebElement profileMenuItem;

    public WebElement getAvatarIcon() {
        return avatarIcon;
    }

    public void clickAvatarIcon() {
        avatarIcon.click();
    }

    public void clickProfileMenuItem() {
        profileMenuItem.click();
    }

    public boolean isAvatarVisible() {
        return avatarIcon.isDisplayed();
    }
}
