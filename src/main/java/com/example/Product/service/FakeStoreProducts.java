package com.example.Product.service;

import com.example.Product.dtos.FakeStoreProductsDto;
import com.example.Product.exception.ProductNotFoundException;
import com.example.Product.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProducts implements ProductService{

     @Override
    public Product getProductById(int id) throws ProductNotFoundException {

         String url = "https://fakestoreapi.com/products/" + id;

         RestTemplate restTemplate = new RestTemplate();
         FakeStoreProductsDto fakeStoreProductsDto = restTemplate.getForObject(url , FakeStoreProductsDto.class);
         if(fakeStoreProductsDto == null){
             throw new ProductNotFoundException("Product is Not Found");
         }
         System.out.println("fakeStoreProductsDto"+fakeStoreProductsDto);
         Product product = convertDtotoProduct(fakeStoreProductsDto);
         return product;
    }

    public List<Product> getAllProducts(){
         String url = "https://fakestoreapi.com/products/";

         RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductsDto[] fakeStoreProductsArray = restTemplate.getForObject(url, FakeStoreProductsDto[].class);

        List<FakeStoreProductsDto> fakeStoreProductsDtoList = Arrays.asList(fakeStoreProductsArray);

        List<Product> productList = new ArrayList<>();

        for(int i = 0 ; i < fakeStoreProductsDtoList.size() ; i++){
            productList.add(convertDtotoProduct(fakeStoreProductsDtoList.get(i)));
        }

        return productList;
    }

    private Product convertDtotoProduct(FakeStoreProductsDto fakeStoreProductsDto){
        Product product = new Product();

         product.setTitle(fakeStoreProductsDto.getTitle());
         product.setId(fakeStoreProductsDto.getId());
         product.setDescription(fakeStoreProductsDto.getDescription());
         product.setPrice(fakeStoreProductsDto.getPrice());
         product.setCategory(fakeStoreProductsDto.getCategory());
         product.setImage(fakeStoreProductsDto.getImage());

         return product;
    }
}