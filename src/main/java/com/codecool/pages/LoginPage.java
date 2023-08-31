package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='login-form-username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@id='login-form-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[@id='captcha']")
    private WebElement captcha;
    @FindBy(xpath = "//div[@id='usernameerror']/p")
    private WebElement loginError;
    @FindBy(xpath = "//div[@id='content']//p")
    private WebElement loginMessage;

    public LoginPage() {
        super();
    }

    private void enterUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void clickLoginBtn() {
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginBtn();
    }

    public String getLoginMessage() {
        return loginMessage.getText();
    }

    public String getLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginError));
        return loginError.getText();
    }

    public boolean isCaptchaVisible() {
        wait.until(ExpectedConditions.visibilityOf(captcha));
        return captcha.isDisplayed();
    }
}
