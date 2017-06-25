package com.spbstu;

import com.spbstu.pageObjets.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by germanium on 16.04.17.
 */
public class MantisSite {
    public static WebDriver driver;

    public static LoginPage loginPage;
    public static MyViewPage myViewPage;
    public static BugReportPage bugReportPage;
    public static ViewAllBugPage viewAllBugPage;
    public static IssueDetailsPage issueDetailsPage;


    public static void init(WebDriver driver) {
        MantisSite.loginPage = PageFactory.initElements(driver, LoginPage.class);
        MantisSite.myViewPage = PageFactory.initElements(driver, MyViewPage.class);
        MantisSite.bugReportPage = PageFactory.initElements(driver, BugReportPage.class);
        MantisSite.viewAllBugPage = PageFactory.initElements(driver, ViewAllBugPage.class);
        MantisSite.issueDetailsPage = PageFactory.initElements(driver, IssueDetailsPage.class);
        MantisSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("http://localhost/mantisbt/login_page.php");
    }
    public static void logout() { driver.navigate().to("http://127.0.0.1/mantisbt/logout_page.php"); }

}
