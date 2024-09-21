package com.example.Product.controller;

import com.example.Product.models.Product;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    ProductService pb ;

    @GetMapping("/{product_id}")

    public ResponseEntity<String> getProductById(@PathVariable int product_id){
        System.out.println("Hello the product id" + product_id);
        Product prodObj = pb.getProductById(product_id);
        return new ResponseEntity<String>("Product_ID " + prodObj , HttpStatusCode.valueOf(200));
    }
}