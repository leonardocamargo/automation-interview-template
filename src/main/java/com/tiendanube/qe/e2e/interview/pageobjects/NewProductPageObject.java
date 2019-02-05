package com.tiendanube.qe.e2e.interview.pageobjects;

import com.tiendanube.qe.e2e.interview.datamodel.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewProductPageObject {

    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(css = "input[id^='name-'")
    private WebElement productNameTxt;
    @FindBy(id = "price")
    private WebElement productPriceTxt;
    @FindBy(id = "stock")
    private WebElement productStockTxt;
    @FindBy(id = "submit-button")
    private WebElement submitBtn;
    @FindBy(css = "div.alert-success")
    private WebElement alertMsg;

    NewProductPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(productNameTxt));
    }

    public NewProductPageObject createProduct(Product newProduct) {
        productNameTxt.sendKeys(newProduct.getName());
        productPriceTxt.sendKeys(newProduct.getPrice());
        productStockTxt.sendKeys(newProduct.getStock());

        this.writeDescription(newProduct.getDescription());

        submitBtn.click();
        return this;
    }

    private void writeDescription(String description) {
        driver.switchTo().frame(1);
        WebElement iFrameBody = driver.findElement(By.cssSelector("body"));
        iFrameBody.sendKeys(description);
        driver.switchTo().parentFrame();
    }

    public boolean wasCreated() {
        return alertMsg.isDisplayed();
    }
}
