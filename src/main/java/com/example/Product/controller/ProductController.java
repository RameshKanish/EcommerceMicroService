package com.example.Product.controller;

import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    ProductService pb ;

    @GetMapping("/{product_id}")
    // Get One product By Id
    public ResponseEntity<Product> getProductById(@PathVariable int product_id) throws ProductNotFoundException {


        Product prodObj = pb.getProductById(product_id);
        System.out.println("Hello" + prodObj);
        return new ResponseEntity<>(prodObj , HttpStatus.ACCEPTED);
    }
    // Get All the products.

    @GetMapping("/")

    public ResponseEntity<List<Product>> getAllProducts (){
        List<Product> productList = pb.getAllProducts();
        if(pb == null){
            throw new NullPointerException("Result is null");
        }
        return new ResponseEntity<>(productList , HttpStatus.OK);
    }
}