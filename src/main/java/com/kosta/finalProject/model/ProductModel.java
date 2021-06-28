package com.kosta.finalProject.model;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("p1", "Name 1", 100, "강희원님.PNG"));
        products.add(new Product("p2", "Name 2", 200, "임상혁님.PNG"));
        products.add(new Product("p3", "Name 3", 300, "정한영님.png"));
        return products;
    }

    public Product find(String id) {
        for (Product product : findAll()) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

}
