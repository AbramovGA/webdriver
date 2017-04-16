package com.spbstu.pageobjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by germanium on 16.04.17.
 */
public class FactoryBugReportPage {

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(css = "input.btn")
    WebElement submitButton;

    public void setIssue(String summary, String description) {
        this.summary.sendKeys(summary);
        this.description.sendKeys(description);
        submitButton.click();
    }

}
