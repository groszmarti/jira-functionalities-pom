package com.codecool.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-form-username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@id='login-form-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginBtn;
    @FindBy(xpath = "//div[@id='captcha']")
    private WebElement captcha;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public boolean isCaptchaVisible() {
        return captcha.isDisplayed();
    }
}
