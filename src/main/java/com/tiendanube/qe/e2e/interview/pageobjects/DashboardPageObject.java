package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObject extends BasePageObject {

    DashboardPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
