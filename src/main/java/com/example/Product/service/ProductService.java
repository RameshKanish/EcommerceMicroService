package com.example.Product.service;

import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(int productId) throws ProductNotFoundException;
    public Product createProduct(String name , Double price , String description , String category , String image) throws  ProductNotFoundException;
    public List<Product> getAllProducts();
    public List<Product> getProductByName(String title);
    public Product updateProduct(int productId);
}