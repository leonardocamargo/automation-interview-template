package com.tiendanube.qe.e2e.interview.tests;

import com.tiendanube.qe.e2e.interview.datamodel.Product;
import com.tiendanube.qe.e2e.interview.datamodel.ProductBuilder;
import com.tiendanube.qe.e2e.interview.pageobjects.LoginPageObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
        final String userEmail = "automation+interview@tiendanube.com";
        final String userPassword = "Interview123";
        final Product newProduct = new ProductBuilder()
                .with($ -> {
                    $.name = "Player's Handbook";
                    $.price = "100";
                    $.stock = "1000";
                    $.description = "The Player’s Handbook is the essential reference for every Dungeons & Dragons roleplayer.";
                })
                .createProduct();

        final ArrayList<Product> productsList = new LoginPageObject(driver)
                .logAs(userEmail, userPassword)
                .navigateToNewProductPage()
                .createProduct(newProduct)
                .navigateToMyProductsPage()
                .getProductsList();

        final Product actualProduct = productsList.stream().filter(product -> product.getName().equals("Player's Handbook")).findFirst().orElse(null);
        Assert.assertNotNull(actualProduct, "The expected product was not found in the product list.");
        Assert.assertEquals(actualProduct.getName(), newProduct.getName(), "The product name does not match.");
        Assert.assertEquals(actualProduct.getPrice(), newProduct.getPrice(), "The product price does not match.");
        Assert.assertEquals(actualProduct.getStock(), newProduct.getStock(), "The product stock does not match.");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
