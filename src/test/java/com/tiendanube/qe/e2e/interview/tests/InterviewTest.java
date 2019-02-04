package com.tiendanube.qe.e2e.interview.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement userMailTxt = driver.findElement(By.id("user-mail"));
        WebElement userPasswordTxt = driver.findElement(By.id("pass"));
        WebElement loginBtn = driver.findElement(By.cssSelector("input.btn"));

        userMailTxt.sendKeys("automation+interview@tiendanube.com");
        userPasswordTxt.sendKeys("Interview123");
        loginBtn.click();

        //Menu Navigation
        WebElement productsMenu = driver.findElement(By.cssSelector("li[data-code=products]"));
        WebElement newProductMenu = driver.findElement(By.cssSelector("a[data-qe-id=product_new-menu-secondary]"));

        productsMenu.click();
        newProductMenu.click();

        //product publication
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("lifecycle-cards"))));

        WebElement productNameTxt = driver.findElement(By.cssSelector("input[id^='name-'"));
        WebElement productPriceTxt = driver.findElement(By.id("price"));
        WebElement productStockTxt = driver.findElement(By.id("stock"));
        WebElement submitBtn = driver.findElement(By.id("submit-button"));


        productNameTxt.sendKeys("Player's Handbook");
        productPriceTxt.sendKeys("100");
        productStockTxt.sendKeys("100");

        driver.switchTo().frame(1);
        WebElement iFrameBody = driver.findElement(By.cssSelector("body"));
        iFrameBody.sendKeys("Producto de prueba");
        driver.switchTo().parentFrame();

        submitBtn.click();
        WebElement alertMsg = driver.findElement(By.cssSelector("div.alert-success"));
        Assert.assertTrue(alertMsg.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
