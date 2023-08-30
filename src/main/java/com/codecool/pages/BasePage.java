package com.codecool.pages;

import com.codecool.util.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriverWait wait;
    private WebDriver driver;

    public BasePage() {
        WebDriverManager driverManager = WebDriverManager.getInstance();
        this.driver = driverManager.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quitDriver() {
        WebDriverManager.quitDriver();
    }

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
