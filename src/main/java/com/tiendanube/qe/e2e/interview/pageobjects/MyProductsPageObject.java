package com.tiendanube.qe.e2e.interview.pageobjects;

import com.tiendanube.qe.e2e.interview.datamodel.Product;
import com.tiendanube.qe.e2e.interview.datamodel.ProductBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MyProductsPageObject extends BasePageObject {

    @FindBy(id = "product-table")
    private WebElement productTable;
    @FindBy(css = "tr.single-product")
    private List<WebElement> productRows;


    MyProductsPageObject(WebDriver driver) {
        super(driver);
        initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(productTable));
    }

    public List<Product> getProductsList() {
        List<Product> productsList = new ArrayList<>();
        productRows.iterator().forEachRemaining(product ->
                productsList.add(new ProductBuilder().with($ -> {
                            $.name = product.findElement(By.cssSelector("td.product-table_product-name")).getText();
                            $.price = product.findElement(By.cssSelector("input[name=price]")).getAttribute("value");
                            $.stock = product.findElement(By.cssSelector("span.stock-count")).getText();
                        }).createProduct()
                ));
        return productsList;
    }
}
