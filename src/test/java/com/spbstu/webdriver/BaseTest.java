package com.spbstu.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    WebDriver driver;

    SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        softAssert = new SoftAssert();
        System.out.println(method.getName());
    }


    @AfterMethod
    public void afterMethod(ITestResult testResult){
        System.out.println(String.format("after method: %s, status: %s",
                testResult.getName(),
                testResult.isSuccess()));
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
