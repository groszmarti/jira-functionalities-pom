package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutPageTest {
    private static LoginPage loginPage;
    private LogoutPage logoutPage;
    private ProfilePage profilePage;
    private Header header;


    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        loginPage.navigateTo(LoginPage.LOGIN_URL);
        header = new Header();
        profilePage = new ProfilePage();
        logoutPage = new LogoutPage();
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
    }

    @AfterEach
    void tearDown() {
        logoutPage.quitDriver();
    }

    @Test
    public void successfulLogoutShouldLogUserOut() {
        header.clickAvatarIcon();
        header.clickLogoutMenuItem();
        String expectedLogoutMessage = "You are now logged out. Any automatic login has also been stopped.";
        Assertions.assertTrue(logoutPage.getLogoutMessage().contains(expectedLogoutMessage));
        logoutPage.navigateTo(GlobalVariables.BASE_URL + ProfilePage.PROFILE_URL);
        String expectedLoginErrorMessage = "You must log in to access this page";
        Assertions.assertTrue(loginPage.getLoginMessage().contains(expectedLoginErrorMessage));
    }
}

