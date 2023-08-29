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
    private WebDriverWait wait;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-details-user-fullname']//img")));
      //  wait.until(ExpectedConditions.visibilityOf(dashboardPage.getAvatarIcon()));
        String userName = driver.findElement(By.xpath("//*[@id='header-details-user-fullname']")).getAttribute("data-username");
        Assertions.assertTrue(userName.contains(Util.VALID_USERNAME));
      //  Assertions.assertTrue(dashboardPage.getAvatarParentDataUsername().contains(Util.VALID_USERNAME));
    }
}