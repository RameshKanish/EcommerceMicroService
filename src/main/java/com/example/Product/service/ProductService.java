package com.example.Product.service;

import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(int id) throws ProductNotFoundException;

    public List<Product> getAllProducts();

}
