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
    private String loginUrl;
    private String profileUrl;


    @BeforeEach
    void setUp() {
        loginUrl = "/secure/Dashboard.jspa";
        loginPage = new LoginPage();
        loginPage.setDriver(loginUrl);
        header = new Header();
        profilePage = new ProfilePage();
        logoutPage = new LogoutPage();
    }

    @AfterEach
    void tearDown() {
        logoutPage.quitDriver();
    }

    @Test
    public void successfulLogoutShouldLogUserOut() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.clickAvatarIcon();
        header.clickLogoutMenuItem();
        String expectedLogoutMessage = "You are now logged out. Any automatic login has also been stopped.";
        Assertions.assertTrue(logoutPage.getLogoutMessage().contains(expectedLogoutMessage));
        profileUrl = "/secure/ViewProfile.jspa";
        logoutPage.navigateTo(GlobalVariables.BASE_URL + profileUrl);
        String expectedLoginErrorMessage = "You must log in to access this page";
        Assertions.assertTrue(loginPage.getLoginMessage().contains(expectedLoginErrorMessage));
    }
}

