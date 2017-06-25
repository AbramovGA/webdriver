package com.spbstu.stepdefs;

import com.spbstu.MantisSite;
import com.spbstu.helper.ResourceLoaderSTU;
import com.spbstu.pageObjets.MyViewPage;
import com.spbstu.pageObjets.entities.Issue;
import com.spbstu.pageObjets.entities.User;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by germanium on 30.05.17.
 */
public class MyStepdefs {

    Issue issue = ResourceLoaderSTU.getIssue();
    User user;

    @Given("^login as \"([^\"]*)\"$")
    public void loginAs(String login) throws Throwable {
        MantisSite.open();
        user = ResourceLoaderSTU.users.get(login);
        MantisSite.loginPage.login(user);
    }

    @And("^click on <Report Issue> button$")
    public void createIssue() throws Throwable {
        MantisSite.myViewPage.reportIssue();
    }

    @When("^fill the form")
    public void fillForm() throws Throwable{
        MantisSite.bugReportPage.setIssue(issue);
    }

    @And("^click on <Submit Issue> button$")
    public void submitIssue() throws Throwable {
        MantisSite.bugReportPage.submitIssue();
    }

    @And("^go to view issues page$")
    public void viewIssues() throws Throwable {
        MantisSite.myViewPage.viewIssues();
    }

    @And("^check for issue report$")
    public void reportCreated() throws Throwable {
        Assert.assertTrue(MantisSite.viewAllBugPage.findEntry(issue));
    }

    @Then("^logout$")
    public void logout() throws Throwable {
        MantisSite.myViewPage.logout();
    }

    @And("^open bug page$")
    public void openBug() {
        MantisSite.viewAllBugPage.findAndOpen(issue);
    }

    @And("^check all fields$")
    public void checkAllFields(){
        Assert.assertTrue(MantisSite.issueDetailsPage.checkAllFields(issue));
    }

    @And("^mark the bug as \"([^\"]*)\"$")
    public void markBug(String status){
        MantisSite.issueDetailsPage.changeStatus(status,issue);
    }

    @And("show closed issues")
    public void showClosed(){
        MantisSite.viewAllBugPage.showClosed();

    }

}
