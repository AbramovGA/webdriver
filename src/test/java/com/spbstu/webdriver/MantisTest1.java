package com.spbstu.webdriver;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

/**
 * Created by germanium on 15.04.17.
 */
public class MantisTest1 extends BaseTest {

    int getLatestIssueID() {
        return Integer.parseInt(driver.findElement(By.cssSelector("#buglist > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > a:nth-child(1)"))
                .getText());
    }

    @Test
    public void reportIssueCheck() {
        //go to login page
        driver.navigate().to("http://localhost/mantisbt/login_page.php");
        //set username
        driver.findElement(By.id("username")).sendKeys("administrator");
        //set password
        driver.findElement(By.id("password")).sendKeys("qwerty");
        //click on Login button
        driver.findElement(By.cssSelector(".width-40")).click();
        //go to View Issues Page
        driver.findElement(By.cssSelector(".nav-list > li:nth-child(2) > a:nth-child(1) > i:nth-child(1)")).click();
        //get the latest issue id
        int latestIssue = getLatestIssueID();
        //click on Report Issue button
        driver.findElement(By.cssSelector("div.btn-group:nth-child(1) > a")).click();
        //set summary
        driver.findElement(By.id("summary")).sendKeys("Summary");
        //set description
        driver.findElement(By.id("description")).sendKeys("description");
        //click Submit Issue button
        driver.findElement(By.cssSelector("input.btn")).click();
        //check if the latest issue id is bigger than it was before reporting an issue
        Assert.assertTrue(latestIssue < getLatestIssueID());


    }
}
