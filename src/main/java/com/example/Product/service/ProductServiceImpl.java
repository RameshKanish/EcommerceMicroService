package com.example.Product.service;

import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;
import com.example.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbImpl")
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository pr;
    public Product createProduct(String name , Double price , String description , String category , String image) throws  ProductNotFoundException{
        Product produt = new Product();

        if(pr.findFirstByTitleAndCategory(name , category).size() <= 0){
            produt.setTitle(name);
            produt.setPrice(price);
            produt.setDescription(description);
            produt.setCategory(category);
            produt.setImage(image);
            Product result = pr.save(produt);

            return result;
        }
        throw new ProductNotFoundException("PProduct name is already found");
    }
    @Override
    public Product getProductById(int id) throws ProductNotFoundException {

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(int productId) {
        return null;
    }
}
