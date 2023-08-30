/*
package com.codecool.pages;

import com.codecool.util.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowseProjectTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private Header dashboardPage;
    private ProjectSummaryPage projectSummaryPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new Header(driver);
        projectSummaryPage = new ProjectSummaryPage(driver);
        driver.get(GlobalVariables.BASE_URL + "/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void browseExistingProjectShouldOpenProject() {
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);
        dashboardPage.isAvatarVisible();
        driver.navigate().to(GlobalVariables.BASE_URL + "/projects/MTP/summary");
        String expectedProjectKey = "MTP";
        Assertions.assertEquals(projectSummaryPage.getProjectKey(), expectedProjectKey);

    }

    */
/*@Test
    public void browseTOUCANProjectShouldOpenTOUCANProjectSummary() {
        loginPage.enterUserName(Util.VALID_USERNAME);
        loginPage.enterPassword(Util.VALID_PASSWORD);
        loginPage.clickLoginBtn();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.isAvatarVisible();

        driver.navigate().to("https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary");

        ProjectSummaryPage projectSummaryPage = new ProjectSummaryPage(driver);
        String expectedProjectKey = "TOUCAN";
        Assertions.assertEquals(projectSummaryPage.getProjectKey(), expectedProjectKey);
    }

    @Test
    public void browseCOALAProjectShouldOpenCOALAProjectSummary() {
        loginPage.enterUserName(Util.VALID_USERNAME);
        loginPage.enterPassword(Util.VALID_PASSWORD);
        loginPage.clickLoginBtn();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.isAvatarVisible();

        driver.navigate().to("https://jira-auto.codecool.metastage.net/projects/COALA/summary");

        ProjectSummaryPage projectSummaryPage = new ProjectSummaryPage(driver);
        String expectedProjectKey = "COALA";
        Assertions.assertEquals(projectSummaryPage.getProjectKey(), expectedProjectKey);
    }
    @Test
    public void browseJETIProjectShouldOpenJETIProjectSummary() {
        loginPage.enterUserName(Util.VALID_USERNAME);
        loginPage.enterPassword(Util.VALID_PASSWORD);
        loginPage.clickLoginBtn();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.isAvatarVisible();

        driver.navigate().to("https://jira-auto.codecool.metastage.net/projects/JETI/summary");

        ProjectSummaryPage projectSummaryPage = new ProjectSummaryPage(driver);
        String expectedProjectKey = "JETI";
        Assertions.assertEquals(projectSummaryPage.getProjectKey(), expectedProjectKey);
    }*//*

}*/
