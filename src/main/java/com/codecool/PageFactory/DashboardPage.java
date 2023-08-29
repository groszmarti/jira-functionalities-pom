package com.codecool.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='header-details-user-fullname']//img")
    private WebElement avatarIcon;

    @FindBy(xpath = "//*[@id='header-details-user-fullname']")
    private WebElement avatarParent;

    @FindBy(xpath = "//a[@id='view_profile']")
    private WebElement profileMenuItem;

    public WebElement getAvatarIcon() {
        return avatarIcon;
    }

    public String getAvatarParentDataUsername() {
        return avatarParent.getAttribute("data-username");
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
    public String getLoggedUserName() {
        return avatarParent.getAttribute("data-username");
    }
}
