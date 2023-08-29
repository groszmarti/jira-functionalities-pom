package com.codecool.PageFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateIssueTest {
    private String path = Util.SRC;
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private IssueSummaryPage issueSummaryPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        issueSummaryPage = new IssueSummaryPage(driver);
        //options.addArguments("--headless=new");
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void issueCreationWithMandatoryFieldsShouldBeSuccessful() {
        loginPage.enterUserName(Util.VALID_USERNAME);
        loginPage.enterPassword(Util.VALID_PASSWORD);
        loginPage.clickLoginBtn();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.isAvatarVisible();

        dashboardPage.clickCreateBtn();
        dashboardPage.isCreateIssueFormVisible();
        String expected = "Create Issue";
        Assertions.assertEquals(expected,dashboardPage.getCreateIssueFormHeaderText());

        dashboardPage.enterTextToProjectInputField("MTP");
        dashboardPage.enterTextToProjectSummary("Create new test issue");
        dashboardPage.clickCreateIssueSubmitBtn();

        dashboardPage.clickPopupWindow();
        String actualProjectId = issueSummaryPage.getprojectId();
        Assertions.assertTrue(dashboardPage.getPopupText().contains(actualProjectId));

        issueSummaryPage.clickMoreBtn();
        issueSummaryPage.clickDeleteissue();
        issueSummaryPage.clickDeleteIssueSubmit();
    }

}
