package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSummaryPage extends BasePage {
    @FindBy(xpath = "//section[@id='summary-body']//dt[contains(@class, 'project-meta-label') and text()='Key']/following-sibling::dd")
    private WebElement projectKey;

    public ProjectSummaryPage() {
        super();
    }

    public String getProjectKey() {
        wait.until(ExpectedConditions.visibilityOf(projectKey));
        return projectKey.getText();
    }

}
