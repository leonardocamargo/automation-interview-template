package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObject {
    private final WebDriver driver;
    private MenuPageObject menu;

    DashboardPageObject(WebDriver driver) {
        this.driver = driver;
        this.menu = new MenuPageObject(driver);
        PageFactory.initElements(driver, this);
    }

    public NewProductPageObject navigateToNewProductPage() {
        return menu.newProduct();
    }
}
