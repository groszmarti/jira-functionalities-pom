package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import com.codecool.util.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private Header header;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        header = new Header();
        profilePage = new ProfilePage();
        driver = WebDriverManager.getInstance().getDriver();
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        WebDriverManager.quitDriver();
    }


    @Test
    public void successfulLoginWorkWithValidData() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.navigateToProfilePage();
        Assertions.assertTrue(profilePage.getProfileUserName().contains(GlobalVariables.VALID_USERNAME));
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
        loginPage.login(GlobalVariables.VALID_USERNAME, "");
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldntWorkWithInvalidPassword() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.INVALID_PASSWORD);
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldntWorkWithInvalidUsername() {
        loginPage.login(GlobalVariables.INVALID_USERNAME, GlobalVariables.INVALID_PASSWORD);
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    //refactor!!!!
    @Test
    public void captchaAppearsAfter3UnsuccessfulLogin() {
        loginPage.login(GlobalVariables.INVALID_USERNAME, GlobalVariables.INVALID_PASSWORD);

        driver.navigate().refresh();
        loginPage.login(GlobalVariables.INVALID_USERNAME, GlobalVariables.INVALID_PASSWORD);

        driver.navigate().refresh();
        loginPage.login(GlobalVariables.INVALID_USERNAME, GlobalVariables.INVALID_PASSWORD);

        Assertions.assertTrue(loginPage.isCaptchaVisible());
    }
}