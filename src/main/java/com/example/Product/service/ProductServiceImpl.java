package com.example.Product.service;

import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;
import com.example.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        Optional<Product> product = Optional.ofNullable(pr.findById(id));

        if(product.isPresent()){
            Product p = product.get();
            return p;
        }
        throw new ProductNotFoundException("Product Not found or id is noy present");
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String title) {
        List<Product> product = pr.findAllByTitleLike(title);
        return product;
    }

    @Override
    public Product updateProduct(int productId) {
        return null;
    }
}