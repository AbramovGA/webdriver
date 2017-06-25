package com.spbstu.pageObjets;

import com.spbstu.MantisSite;
import com.spbstu.pageObjets.entities.Issue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.spbstu.MantisSite.driver;

/**
 * Created by germanium on 30.05.17.
 */
public class IssueDetailsPage {

    @FindBy(css = "td.bug-reporter")
    WebElement reporter;

    @FindBy(css = "td.bug-assigned-to")
    WebElement assignTo;

    @FindBy(css = "td.bug-reproducibility")
    WebElement reproducibility;

    @FindBy(css = "td.bug-severity")
    WebElement severity;

    @FindBy(css = "td.bug-priority")
    WebElement priority;

    @FindBy(css = "td.bug-platform")
    WebElement platform;

    @FindBy(css = "td.bug-os")
    WebElement os;

    @FindBy(css = "td.bug-os-version")
    WebElement osVer;

    @FindBy(css = "td.bug-status")
    WebElement status;

    @FindBy(css = "td.bug-summary")
    WebElement summary;

    @FindBy(css = "td.bug-description")
    WebElement description;

    @FindBy(css = "td.bug-steps-to-reproduce")
    WebElement stepsToReproduce;

    @FindBy(css = "td.bug-additional-information")
    WebElement additionalInformation;

    @FindBy(css = "td.bug-resolution")
    WebElement resolution;

    @FindBy(css = "input.btn-sm:nth-child(1)")
    WebElement changeStatusButton;

    @FindBy(css = "div:nth-child(3) > form > select")
    WebElement changeStatusList;

    @FindBy(css = ".btn-white")
    WebElement resolveButton;

    @FindBy(css=".user-info")
    WebElement currentUser;

    @FindBy(xpath = "//*[@id=\"bug-change-status-form\"]/fieldset/div/div[2]/div[1]/div/table/tbody/tr[1]/td/select")
    WebElement assignedTo;

    @FindBy(xpath = "//*[@id=\"bug-change-status-form\"]/fieldset/div/div[2]/div[1]/div/table/tbody/tr[1]/td/select/option[4]")
    WebElement assignToLead;

    public boolean checkAllFields(Issue issue){
        return (reporter.getText().equals(issue.getReporter())
                && assignTo.getText().equals(issue.getAssignedTo())
                && reproducibility.getText().equals(issue.getReproducibility())
                && severity.getText().equals(issue.getSeverity())
                && priority.getText().equals(issue.getPriority())
                && platform.getText().equals(issue.getPlatform())
                && os.getText().equals(issue.getOs())
                && osVer.getText().equals(issue.getOsVersion())
                && status.getText().equals("assigned")
                && summary.getText().contains(issue.getSummary())
                && description.getText().equals(issue.getDescription())
                && stepsToReproduce.getText().equals(issue.getStepsToReproduce())
                && additionalInformation.getText().equals(issue.getAdditionalInformation())
                && resolution.getText().equals("open")
        );
    }

    public void changeStatus(String status, Issue issue){
        changeStatusList.click();
        WebElement temporary;
        for(int i=1;i<7;i++){
            temporary= driver
                    .findElement(By.cssSelector("select.input-sm:nth-child(2) > option:nth-child("+i+")"));
            if(temporary.getText().equals(status)){
                temporary.click();
                changeStatusButton.click();
                switch(status) {
                    case "resolved":
                        issue.setStatus(status+" ("+assignTo.getText()+")");
                        break;
                    case "closed":
                        assignedTo.click();
                        assignToLead.click();
                        issue.setStatus(status+" ("+currentUser.getText()+")");
                        break;
                }
                resolveButton.click();
                break;
            }
        }

    }
}
