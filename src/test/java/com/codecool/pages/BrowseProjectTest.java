package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BrowseProjectTest {
    private LoginPage loginPage;
    private Header header;
    private ProjectSummaryPage projectSummaryPage;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        header = new Header();
        projectSummaryPage = new ProjectSummaryPage();
        loginPage.navigateTo(LoginPage.LOGIN_URL);
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
    }

    @AfterEach
    void tearDown() {
        projectSummaryPage.quitDriver();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/browseProjects.csv", numLinesToSkip = 1)
    public void validateProjectBrowsePermission(String projectUrl, String projectKey) {
        header.isAvatarVisible();
        projectSummaryPage.navigateTo(projectUrl);
        String actualProjectKey = projectSummaryPage.getProjectKey();
        Assertions.assertEquals(projectKey, actualProjectKey);
    }
}
