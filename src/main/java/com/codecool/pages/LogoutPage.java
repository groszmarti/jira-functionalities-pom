package com.codecool.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//div[@id='content']//p")
    WebElement logoutMessage;

//


    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getLogoutMessage() {
        return logoutMessage.getText();
    }
}
