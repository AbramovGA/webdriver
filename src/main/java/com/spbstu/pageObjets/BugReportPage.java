package com.spbstu.pageObjets;

import com.spbstu.pageObjets.entities.Issue;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by germanium on 30.05.17.
 */
public class BugReportPage {

    @FindBy(id = "category_id")
    WebElement category;

    @FindBy(id = "reproducibility")
    WebElement reproducibility;

    @FindBy(id = "severity")
    WebElement severity;

    @FindBy(id = "priority")
    WebElement priority;

    @FindBy(id = "platform")
    WebElement platform;

    @FindBy(id = "os")
    WebElement os;

    @FindBy(id = "os_build")
    WebElement osVersion;

    @FindBy(id = "handler_id")
    WebElement assignedTo;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "steps_to_reproduce")
    WebElement stepsToReproduce;

    @FindBy(id = "additional_info")
    WebElement additionalInfo;

    @FindBy(css = "input.btn")
    WebElement submitBtn;

    @FindBy(css = ".fa-plus-square-o")
    WebElement selectProfileBtn;

    @FindBy(css = "table.table-bordered:nth-child(2)")
    WebElement platformTable;


    public void setIssue(Issue issue) {

        new Select(category).selectByVisibleText(issue.getCategory());
        new Select(reproducibility).selectByVisibleText(issue.getReproducibility());
        new Select(severity).selectByVisibleText(issue.getSeverity());
        new Select(priority).selectByVisibleText(issue.getPriority());
        if(!platformTable.isDisplayed())
            selectProfileBtn.click();

        platform.sendKeys(issue.getPlatform());
        os.sendKeys(issue.getOs());
        osVersion.sendKeys(issue.getOsVersion());
        new Select(assignedTo).selectByVisibleText(issue.getAssignedTo());
        summary.sendKeys(issue.getSummary());
        description.sendKeys(issue.getDescription());
        stepsToReproduce.sendKeys(issue.getStepsToReproduce());
        additionalInfo.sendKeys(issue.getAdditionalInformation());

    }

    public void submitIssue(){
        submitBtn.click();
    }

}
