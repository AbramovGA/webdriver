package com.spbstu.pageObjets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by germanium on 30.05.17.
 */
public class MyViewPage {

    @FindBy(css = "div.btn-group:nth-child(1) > a:nth-child(1)")
    WebElement reportIssueButton;

    @FindBy(css = ".nav-list > li:nth-child(2)")
    WebElement viewIssuesPage;

    @FindBy(css = ".dropdown-toggle")
    WebElement accountSettingsList;

    @FindBy(css = ".user-menu > li:nth-child(4) > a:nth-child(1)")
    WebElement logoutBtn;




    public void reportIssue() {
        reportIssueButton.click();
    }

    public void viewIssues() {
        viewIssuesPage.click();
    }

    public void logout() {
            accountSettingsList.click();
            logoutBtn.click();
    }
}
