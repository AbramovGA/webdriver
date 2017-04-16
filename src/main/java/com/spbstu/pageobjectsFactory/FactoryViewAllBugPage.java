package com.spbstu.pageobjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by germanium on 16.04.17.
 */
public class FactoryViewAllBugPage {

    @FindBy(css = "#buglist > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > a:nth-child(1)")
    WebElement latestIssueID;

    @FindBy(css = "div.btn-group:nth-child(1) > a")
    WebElement reportIssueButton;

    public void reportIssue() {
        reportIssueButton.click();
    }

    public int getLatestIssueID() {
        return Integer.parseInt(latestIssueID.getText());
    }

}
