package com.spbstu.webdriver;

import com.spbstu.MantisSite;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by germanium on 16.04.17.
 */
public class MantisTest2 extends BaseTest {

    @Test
    public void reportIssueCheck() {
        MantisSite.init(driver);
        MantisSite.open();
        MantisSite.loginPage.login("administrator", "qwerty");
        MantisSite.myViewPage.goToIssuesTab();
        int latestIssueID = MantisSite.viewAllBugPage.getLatestIssueID();
        MantisSite.viewAllBugPage.reportIssue();
        MantisSite.bugReportPage.setIssue("summary", "description");
        Assert.assertTrue(latestIssueID < MantisSite.viewAllBugPage.getLatestIssueID());

    }
}
