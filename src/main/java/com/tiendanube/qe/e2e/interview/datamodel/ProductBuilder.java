package com.tiendanube.qe.e2e.interview.datamodel;

import java.util.function.Consumer;

public class ProductBuilder {
    public String name;
    public String price;
    public String stock;
    public String description;

    public ProductBuilder with(
            Consumer<ProductBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Product createProduct() {
        return new Product(name, price, stock, description);
    }
}