package com.tiendanube.qe.e2e.interview.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageObject implements MenuNavigation {

  final WebDriverWait wait;
  final WebDriver driver;
  private MenuPageObject menu;


  BasePageObject(WebDriver driver) {
    this.driver = driver;
    this.menu = new MenuPageObject(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }

  @Override
  public MyProductsPageObject navigateToMyProductsPage() {
    return menu.myProducts();
  }

}
