package com.codecool.PageFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

class LoginPageTest {
    private String path = Util.SRC;
    private WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private DashboardPage dashboardPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
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
        dashboardPage.clickAvatarIcon();
        Assertions.assertTrue(dashboardPage.getAvatarParentDataUsername().contains(Util.VALID_USERNAME));
        dashboardPage.clickProfileMenuItem();
        profilePage = new ProfilePage(driver);
        Assertions.assertTrue(profilePage.getProfileUserName().contains(Util.VALID_USERNAME));
        profilePage.clickAvatarIcon();
        profilePage.clickLogoutMenuItem();
    }

    @Test
    public void unsuccessfulLoginShouldntWorkWithEmptyInputFields() {
        loginPage.clickLoginBtn();
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }
}