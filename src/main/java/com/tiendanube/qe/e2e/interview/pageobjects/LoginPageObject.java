package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPageObject {

    private final WebDriver driver;
    @FindBy(id = "user-mail")
    private WebElement userMailTxt;
    @FindBy(id = "pass")
    private WebElement userPasswordTxt;
    @FindBy(css = "input.btn")
    private WebElement loginBtn;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public DashboardPageObject logAs(String userEmail, String userPassword) {
        userMailTxt.sendKeys(userEmail);
        userPasswordTxt.sendKeys(userPassword);
        loginBtn.click();
        return new DashboardPageObject(driver);
    }
}
