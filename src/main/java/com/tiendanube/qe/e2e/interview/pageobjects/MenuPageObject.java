package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class MenuPageObject {
    private final WebDriver driver;
    @FindBy(css = "li[data-code=products]")
    private WebElement productsMenu;
    @FindBy(css = "a[data-qe-id=product_new-menu-secondary]")
    private WebElement newProductMenu;

    MenuPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    NewProductPageObject newProduct() {
        productsMenu.click();
        newProductMenu.click();
        return new NewProductPageObject(driver);
    }
}
