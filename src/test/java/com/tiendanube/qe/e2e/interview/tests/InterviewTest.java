package com.tiendanube.qe.e2e.interview.tests;

import com.tiendanube.qe.e2e.interview.datamodel.Product;
import com.tiendanube.qe.e2e.interview.datamodel.ProductBuilder;
import com.tiendanube.qe.e2e.interview.pageobjects.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

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

  @Test
  public void createProductTest() {
    //ARRANGE
    final String userEmail = "automation+interview@tiendanube.com";
    final String userPassword = "interview123";
    final Product newProduct = new ProductBuilder()
        .with($ -> {
          $.name = "Player's Handbook";
          $.price = "100";
          $.stock = "1000";
          $.description = "The Player’s Handbook is the essential reference for every Dungeons & Dragons roleplayer.";
        })
        .createProduct();

    //ACT
    final List<Product> productsList = new LoginPageObject(driver)
        .logAs(userEmail, userPassword)
        .navigateToMyProductsPage()
        .addProduct()
        .publishProduct(newProduct)
        .navigateToMyProductsPage()
        .getProductsList();

    //ASSERT
    final Product actualProduct = productsList.stream().filter(product -> product.getName().equals("Player's Handbook")).findFirst().orElse(null);
    assertNotNull(actualProduct, "The expected product was not found in the product list.");
    assertEquals(actualProduct.getName(), newProduct.getName(), "The product name does not match.");
    assertEquals(actualProduct.getPrice(), newProduct.getPrice(), "The product price does not match.");
    assertEquals(actualProduct.getStock(), newProduct.getStock(), "The product stock does not match.");
  }

  @AfterTest
  public void tearDown() {
    driver.close();
  }

}
