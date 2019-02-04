package com.tiendanube.qe.e2e.interview.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InterviewTest {
    private ChromeDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://www.localnube.com.br/login");
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        //Login
        driver.findElement(By.id("user-mail")).sendKeys("automation+interview@tiendanube.com");
        driver.findElement(By.id("pass")).sendKeys("Interview123");
        driver.findElement(By.cssSelector("input.btn")).click();
        Assert.assertTrue(driver.findElement(By.id("lifecycle-cards")).isDisplayed(), "The dashboard's cards should be visible.");

        //Menu Navigation
        driver.findElement(By.cssSelector("li[data-code=products]")).click();
        driver.findElement(By.cssSelector("a[data-qe-id=product_new-menu-secondary]")).click();

        //product publication
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name-container"))));
        Assert.assertTrue(driver.findElement(By.id("name-container")).isDisplayed());

        driver.findElement(By.cssSelector("input[id^='name-'")).sendKeys("Player's Handbook");
        driver.findElement(By.id("price")).sendKeys("100");
        driver.findElement(By.id("stock")).sendKeys("100");

        driver.switchTo().frame(1);
        driver.findElement(By.cssSelector("body")).sendKeys("Prueba 123");
        driver.switchTo().parentFrame();

        driver.findElement(By.id("submit-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());

    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
