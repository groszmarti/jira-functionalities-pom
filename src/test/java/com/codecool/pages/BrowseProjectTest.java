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
    private String loginUrl;

    @BeforeEach
    void setUp() {
        loginUrl = "/secure/Dashboard.jspa";
        loginPage = new LoginPage();
        header = new Header();
        projectSummaryPage = new ProjectSummaryPage();
        loginPage.setDriver(loginUrl);
    }

    @AfterEach
    void tearDown() {
        projectSummaryPage.quitDriver();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/browseProjects.csv", numLinesToSkip = 1)
    public void validateProjectBrowsePermission(String projectUrl, String projectKey) {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        header.isAvatarVisible();
        projectSummaryPage.navigateTo(GlobalVariables.BASE_URL + projectUrl);
        String actualProjectKey = projectSummaryPage.getProjectKey();
        Assertions.assertEquals(projectKey, actualProjectKey);
    }
}
