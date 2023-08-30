package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import com.codecool.util.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

class LoginPageTest {
    private static WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private Header header;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        header = new Header();
        profilePage = new ProfilePage();
        driver = WebDriverManager.getInstance();
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test

    public void successfulLoginWorkWithValidData() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.navigateToProfilePage();
        assert GlobalVariables.VALID_USERNAME != null;
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