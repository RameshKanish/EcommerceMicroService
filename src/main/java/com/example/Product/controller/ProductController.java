package com.example.Product.controller;

import com.example.Product.dtos.CreateProductDto;
import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    @Qualifier("dbImpl")
    ProductService pb ;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto cdto) throws ProductNotFoundException{

        Product product = pb.createProduct(cdto.getTitle() , cdto.getPrice() , cdto.getDescription() , cdto.getCategory() , cdto.getImage());
        return new ResponseEntity<>(product , HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateProduct/{product_id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int product_id){
        Product product = pb.updateProduct(product_id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }


    @GetMapping("/{product_id}")
        public ResponseEntity<Product> getProductById(@PathVariable int product_id) throws ProductNotFoundException {
        Product prodObj = pb.getProductById(product_id);
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
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String name){

        List<Product> productList = pb.getProductByName(name);
        return new ResponseEntity<>(productList , HttpStatus.ACCEPTED);
    }
}