package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSummaryPage extends BasePage {
      @FindBy(xpath = "/html//section[@id='summary-body']//dl/dd[2]")
    ////dd[normalize-space()='MTP']
    WebElement projectKey;

    public ProjectSummaryPage() {
        super();
    }

    public String getProjectKey() {
        wait.until(ExpectedConditions.visibilityOf(projectKey));
        return projectKey.getText();
    }

}
