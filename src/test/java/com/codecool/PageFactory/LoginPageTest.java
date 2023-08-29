package com.codecool.PageFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        dashboardPage = new DashboardPage(driver);
        profilePage = new ProfilePage(driver);
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
      //  dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAvatarIcon();
        Assertions.assertTrue(dashboardPage.getAvatarParentDataUsername().contains(Util.VALID_USERNAME));
        dashboardPage.clickProfileMenuItem();
     //   profilePage = new ProfilePage(driver);
        Assertions.assertTrue(profilePage.getProfileUserName().contains(Util.VALID_USERNAME));
        profilePage.clickAvatarIcon();
        profilePage.clickLogoutMenuItem();
    }

    @Test
    public void short_SuccessfulLoginWorkWithValidData() {
        loginPage.login(Util.VALID_USERNAME, Util.VALID_PASSWORD);
        dashboardPage.navigateToProfilePage();
        Assertions.assertTrue(profilePage.getProfileUserName().contains(Util.VALID_USERNAME));
        profilePage.logOut();
    }

    @Test
    public void unsuccessfulLoginShouldntWorkWithEmptyInputFields() {
        loginPage.login("", "");
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }
    @Test
    public void unsuccessfulLoginShouldntWorkWithEmptyPassword() {
        loginPage.login(Util.VALID_USERNAME, "");
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldntWorkWithInvalidPassword() {
        loginPage.login(Util.VALID_USERNAME, Util.INVALID_PASSWORD);
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldntWorkWithInvalidUsername() {
        loginPage.login(Util.INVALID_USERNAME, Util.INVALID_PASSWORD);
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    //refactor!!!!
    @Test
    public void captchaAppearsAfter3UnsuccessfulLogin() {
        loginPage.login(Util.INVALID_USERNAME, Util.INVALID_PASSWORD);
        driver.close();

        System.setProperty("webdriver.chrome.driver", Util.SRC);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        loginPage = new LoginPage(driver);
        loginPage.login(Util.INVALID_USERNAME, Util.INVALID_PASSWORD);
        loginPage.clickLoginBtn();

        driver.close();

        System.setProperty("webdriver.chrome.driver", Util.SRC);
        driver = new ChromeDriver(options);

        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        loginPage = new LoginPage(driver);
        loginPage.login(Util.INVALID_USERNAME, Util.INVALID_PASSWORD);
        loginPage.clickLoginBtn();

        Assertions.assertTrue(loginPage.isCaptchaVisible());
    }
}