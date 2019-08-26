package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

class MenuPageObject {

  private final WebDriver driver;

  @FindBy(css = "svg.fa-home")
  private WebElement dashboardMenu;
  @FindBy(css = "a[data-qe-id=products")
  private WebElement productsMenu;
  @FindBy(css = "a[data-qe-id='products-menu-secondary']")
  private WebElement myProductsMenu;

  MenuPageObject(WebDriver driver) {
    this.driver = driver;
    initElements(driver, this);
  }

  MyProductsPageObject myProducts() {
    if (!myProductsMenu.isDisplayed()) {
      productsMenu.click();
    }
    myProductsMenu.click();
    return new MyProductsPageObject(driver);
  }

}
