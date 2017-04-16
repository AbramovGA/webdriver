package com.spbstu.pageobjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by germanium on 16.04.17.
 */
public class FactoryMyViewPage {

    @FindBy(css = ".nav-list > li:nth-child(2) > a:nth-child(1) > i:nth-child(1)")
    WebElement reportIssueButton;

    public void goToIssuesTab() {
        reportIssueButton.click();
    }
}
