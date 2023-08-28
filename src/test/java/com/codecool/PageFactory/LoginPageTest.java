package com.codecool.PageFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class LoginPageTest {
    private String path = Util.SRC;
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless=new");
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulLoginShouldWorkWithValidData() {
        loginPage.enterUserName(Util.VALID_USERNAME);
        loginPage.enterPassword(Util.VALID_PASSWORD);
        loginPage.clickLoginBtn();
        dashboardPage = new DashboardPage(driver);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getAvatarIcon())).click();
    }
}