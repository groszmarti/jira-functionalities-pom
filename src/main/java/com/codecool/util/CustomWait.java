package com.codecool.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {

    private WebDriverWait wait;

    public CustomWait() {
        this.wait = new WebDriverWait(WebDriverManager.getInstance(), Duration.ofSeconds(10));
    }

    public void waitForElementToBeInteractableAndSendKeys(String id, String input) {
        try {
            By elementId = By.id(id);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementId));
            element.click();
            element.sendKeys(input);
            element.sendKeys(Keys.ENTER);
        } catch (TimeoutException e) {
            By elementId = By.id(id);
            wait.until(ExpectedConditions.elementToBeClickable(elementId)).sendKeys(input);
            System.out.println("Timeout occurred while waiting for element.");
        } catch (ElementNotInteractableException e) {
            By elementId = By.id(id);
            wait.until(ExpectedConditions.elementToBeClickable(elementId)).sendKeys(input);
            System.out.println("Element not interactable exception occurred.");
        } catch (StaleElementReferenceException e) {
            By elementId = By.id(id);
            wait.until(ExpectedConditions.elementToBeClickable(elementId)).sendKeys(input);
            System.out.println("Stale element exception occurred.");
        } catch (NoSuchElementException e) {
            By elementId = By.id(id);
            wait.until(ExpectedConditions.elementToBeClickable(elementId)).sendKeys(input);
            System.out.println("No such element exception occurred.");
        }
    }
}
