package com.tiendanube.qe.e2e.interview.tests;

import com.tiendanube.qe.e2e.interview.datamodel.Product;
import com.tiendanube.qe.e2e.interview.datamodel.ProductBuilder;
import com.tiendanube.qe.e2e.interview.pageobjects.DashboardPageObject;
import com.tiendanube.qe.e2e.interview.pageobjects.LoginPageObject;
import com.tiendanube.qe.e2e.interview.pageobjects.NewProductPageObject;
import org.openqa.selenium.chrome.ChromeDriver;
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
        String userEmail = "automation+interview@tiendanube.com";
        String userPassword = "Interview123";
        Product newProduct = new ProductBuilder()
                .with($ -> {
                    $.name = "Player's Handbook";
                    $.price = "100";
                    $.stock = "1000";
                    $.description = "The Player’s Handbook is the essential reference for every Dungeons & Dragons roleplayer.";
                })
                .createProduct();

        LoginPageObject loginPage = new LoginPageObject(driver);
        DashboardPageObject dashboardPage = loginPage.logAs(userEmail, userPassword);
        NewProductPageObject newProductPage = dashboardPage.navigateToNewProductPage();
        newProductPage.createProduct(newProduct);
        Assert.assertTrue(newProductPage.wasCreated());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
