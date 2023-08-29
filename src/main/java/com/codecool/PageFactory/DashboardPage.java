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

    public void clickAvatarIcon() {
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
        wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        avatarIcon.click();
    }

    public void clickProfileMenuItem() {
        wait.until(ExpectedConditions.visibilityOf(profileMenuItem));
        profileMenuItem.click();
    }

    public boolean isAvatarVisible() {
        return avatarIcon.isDisplayed();
    }
    public String getLoggedUserName() {
        return avatarParent.getAttribute("data-username");
    }
}
