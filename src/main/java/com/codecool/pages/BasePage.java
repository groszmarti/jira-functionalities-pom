package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import com.codecool.util.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codecool.util.WebDriverManager.getInstance;

public abstract class BasePage {
    protected WebDriverWait wait;
    private WebDriver driver;

    public BasePage() {
        this.driver = getInstance();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void setDriver(String uniqueUrl) {
        driver.get(GlobalVariables.BASE_URL + uniqueUrl);
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        WebDriverManager.quitDriver();
    }

    public void driverRefresh() {
        driver.navigate().refresh();
    }

    public void navigateTo(String uniqueUrl){
        driver.navigate().to(uniqueUrl);
    }

}
