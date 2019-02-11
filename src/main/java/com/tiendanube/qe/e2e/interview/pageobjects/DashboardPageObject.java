package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class DashboardPageObject extends BasePageObject {

    DashboardPageObject(WebDriver driver) {
        super(driver);
        initElements(driver, this);
    }

}
