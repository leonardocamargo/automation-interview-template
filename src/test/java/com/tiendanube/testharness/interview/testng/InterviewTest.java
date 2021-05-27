package com.tiendanube.testharness.interview.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class InterviewTest {
  private ChromeDriver driver;

  @BeforeTest
  public void setUp() {
    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.get("https://www.tiendanube.com/login");
    driver.manage().window().maximize();
  }

  @AfterTest
  public void tearDown() {
    driver.close();
  }

}
