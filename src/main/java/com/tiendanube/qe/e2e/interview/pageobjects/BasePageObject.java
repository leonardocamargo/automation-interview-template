package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject implements MenuNavigation {

    final WebDriverWait wait;
    final WebDriver driver;
    private MenuPageObject menu;


    BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.menu = new MenuPageObject(driver);
        this.wait = new WebDriverWait(driver, 5);
    }

    @Override
    public NewProductPageObject navigateToNewProductPage() {
        return menu.newProduct();
    }

    @Override
    public MyProductsPageObject navigateToMyProductsPage() {
        return menu.myProducts();
    }

}
