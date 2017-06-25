package com.spbstu.pageObjets;

import com.spbstu.MantisSite;
import com.spbstu.pageObjets.entities.Issue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * Created by germanium on 30.05.17.
 */
public class ViewAllBugPage {

    @FindBy(css = "#hide_status_filter")
    WebElement hideStatus;

    @FindBy(css = "select.input-xs")
    WebElement showStatuses;

    @FindBy(css = "select.input-xs > option:nth-child(1)")
    WebElement hideNone;

    @FindBy(css = "input.btn:nth-child(2)")
    WebElement applyFilter;

    public void showClosed(){
        hideStatus.click();
        showStatuses.click();
        hideNone.click();
        applyFilter.click();
    }

    public boolean findEntry(Issue issue) {

        return (MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr"))
                .stream().anyMatch(row ->
                        (row.getText().contains(issue.getSummary()))
                                && (row.getText().contains(issue.getStatus()))
                                && (row.getText().contains(issue.getSeverity()))
                                && (row.getText().contains("General"))));
    }

    public void findAndOpen(Issue issue) {

        (MantisSite.driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr"))
                .stream().filter(row ->
                        (row.getText().contains(issue.getSummary()))
                                && (row.getText().contains(issue.getStatus()))
                                && (row.getText().contains(issue.getSeverity()))
                                && (row.getText().contains("General"))))
                .findAny()
                .get()
                .findElement(By.xpath("//td[@class='column-id']/a")).click();
    }


}
