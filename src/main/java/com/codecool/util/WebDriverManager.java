package com.codecool.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;

    private WebDriverManager() {
    }

    public static WebDriver getInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        return driver;
//        return driver == null ? driver = new ChromeDriver() : driver;
    }


    public static void quitDriver() {
        driver.quit();
    }
}
