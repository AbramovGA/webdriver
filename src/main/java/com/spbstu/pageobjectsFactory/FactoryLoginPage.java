package com.spbstu.pageobjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by germanium on 16.04.17.
 */
public class FactoryLoginPage {

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = ".width-40")
    WebElement loginButton;

    public void login(String login, String password) {
        username.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }


}
