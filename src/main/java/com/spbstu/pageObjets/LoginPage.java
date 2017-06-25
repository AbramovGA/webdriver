package com.spbstu.pageObjets;

import com.spbstu.pageObjets.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by germanium on 30.05.17.
 */
public class LoginPage {

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = ".btn-success")
    WebElement loginButton;

    public void login(User user) {
        username.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword());
        loginButton.click();
    }


}
