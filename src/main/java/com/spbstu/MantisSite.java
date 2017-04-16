package com.spbstu;

import com.spbstu.pageobjectsFactory.FactoryBugReportPage;
import com.spbstu.pageobjectsFactory.FactoryLoginPage;
import com.spbstu.pageobjectsFactory.FactoryMyViewPage;
import com.spbstu.pageobjectsFactory.FactoryViewAllBugPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by germanium on 16.04.17.
 */
public class MantisSite {
    public static WebDriver driver;

    public static FactoryLoginPage loginPage;
    public static FactoryMyViewPage myViewPage;
    public static FactoryBugReportPage bugReportPage;
    public static FactoryViewAllBugPage viewAllBugPage;

    public static void init(WebDriver driver) {
        MantisSite.loginPage = PageFactory.initElements(driver, FactoryLoginPage.class);
        MantisSite.myViewPage = PageFactory.initElements(driver, FactoryMyViewPage.class);
        MantisSite.bugReportPage = PageFactory.initElements(driver, FactoryBugReportPage.class);
        MantisSite.viewAllBugPage = PageFactory.initElements(driver, FactoryViewAllBugPage.class);

        MantisSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("http://localhost/mantisbt/login_page.php");
    }

}
