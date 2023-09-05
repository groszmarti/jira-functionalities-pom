package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.*;

class LoginPageTest {
    private static LoginPage loginPage;
    private ProfilePage profilePage;
    private Header header;


    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        header = new Header();
        profilePage = new ProfilePage();
        loginPage.navigateTo(LoginPage.LOGIN_URL);
    }

    @AfterEach
    void tearDown() {
        loginPage.quitDriver();
    }

    @Test

    public void successfulLoginWorkWithValidData() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.navigateToProfilePage();
        assert GlobalVariables.VALID_USERNAME != null;
        Assertions.assertTrue(profilePage.getProfileUserName().contains(GlobalVariables.VALID_USERNAME));
    }

    @Test
    public void unsuccessfulLoginShouldNotWorkWithEmptyInputFields() {
        loginPage.login("", "");
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldNotWorkWithEmptyPassword() {
        loginPage.login(GlobalVariables.VALID_USERNAME, "");
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldNotWorkWithInvalidPassword() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.INVALID_PASSWORD);
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void unsuccessfulLoginShouldNotWorkWithInvalidUsername() {
        loginPage.login(GlobalVariables.INVALID_USERNAME, GlobalVariables.INVALID_PASSWORD);
        String expectedErrorMessage = "Sorry, your username and password are incorrect";
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains(expectedErrorMessage));
    }

    @Test
    public void captchaAppearsAfter3UnsuccessfulLogin() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.INVALID_PASSWORD);

        loginPage.driverRefresh();
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.INVALID_PASSWORD);

        loginPage.driverRefresh();
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.INVALID_PASSWORD);

        Assertions.assertTrue(loginPage.isCaptchaInteractable());
    }
}