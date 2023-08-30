/*
package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogoutPageTest {
    private String path = GlobalVariables.SRC;
    private WebDriver driver;
    private LoginPage loginPage;
    private Header dashboardPage;

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
    public void successfulLogoutShouldLogUserOut() {
        loginPage.enterUserName(GlobalVariables.VALID_USERNAME);
        loginPage.enterPassword(GlobalVariables.VALID_PASSWORD);
        loginPage.clickLoginBtn();
        dashboardPage = new Header(driver);
        dashboardPage.clickAvatarIcon();
        dashboardPage.clickLogoutMenuItem();
        String expectedLogoutMessage = "You are now logged out. Any automatic login has also been stopped.";
        LogoutPage logoutPage = new LogoutPage(driver);
        Assertions.assertTrue(logoutPage.getLogoutMessage().contains(expectedLogoutMessage));
        driver.navigate().to("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");
        String expectedLoginErrorMessage = "You must log in to access this page";
        Assertions.assertTrue(loginPage.getLoginMessage().contains(expectedLoginErrorMessage));
    }
}
*/
