package com.spbstu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SimpleTest extends BaseTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"spbstu", Arrays.asList("https://vk.com/pgpuspb",
                        "www.spbstu.ru/",
                        "https://openedu.ru/university/spbstu/")},

                {"itmo", Arrays.asList("https://ru.wikipedia.org/wiki/Университет_ИТМО",
                        "https://vk.com/spbifmo")}
        };
    }

    @Test(dataProvider = "data", dataProviderClass = SimpleTest.class)
    public void test1(String searchString, List<String> expected) {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys(searchString + Keys.ENTER);
        List<String> actual = driver.findElements(By.xpath("//*[@id='res']//div[@class='g']//cite"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        expected.forEach((e) -> softAssert.assertTrue(actual.stream().anyMatch(ee -> ee.contains(e)),
                String.format("Element: %s is missing", e)));

        softAssert.assertAll();
    }


}