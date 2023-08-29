package com.codecool.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectSummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "/html//section[@id='summary-body']//dl/dd[2]")
    ////dd[normalize-space()='MTP']
    WebElement projectKey;

    public ProjectSummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getProjectKey() {
        wait.until(ExpectedConditions.visibilityOf(projectKey));
        return projectKey.getText();
    }

}
