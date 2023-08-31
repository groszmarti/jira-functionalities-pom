package com.codecool.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
    @FindBy(xpath = "//div[@id='content']//p")
    private WebElement logoutMessage;


    public LogoutPage() {
        super();
    }

    public String getLogoutMessage() {
        return logoutMessage.getText();
    }
}
