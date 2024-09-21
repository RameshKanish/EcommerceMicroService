package com.example.Product.service;

import com.example.Product.models.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProducts implements ProductService{

    @Override
    public Product getProductById(int id) {
        System.out.println("The product is " + id);
        Product p = new Product();
        p.setId(id);
        return p;
    }
}
