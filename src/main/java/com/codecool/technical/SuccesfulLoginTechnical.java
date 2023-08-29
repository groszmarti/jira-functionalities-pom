package com.codecool.technical;

import com.codecool.PageFactory.LoginPage;
import com.codecool.PageFactory.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuccesfulLoginTechnical {
    private String path = Util.SRC;
    private WebDriver driver;
    private LoginPage loginPage;

    public SuccesfulLoginTechnical(WebDriver driver) {
        this.driver = driver;

    }

    public void setup() {
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        //options.addArguments("--headless=new");
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    public void login() {
        setup();
        loginPage.enterUserName(Util.VALID_USERNAME);
        loginPage.enterPassword(Util.VALID_PASSWORD);
        loginPage.clickLoginBtn();
    }
}
