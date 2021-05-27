package com.tiendanube.testharness.interview.cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

  private WebDriver driver;

  @Before
  public void setup() {

    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.get("https://www.tiendanube.com/login");
    driver.manage().window().maximize();
  }

  @After
  public void tearDown() {
    driver.close();
  }
    
}