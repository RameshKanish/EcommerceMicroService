package com.example.Product.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductsDto {
    public int id;
    public String title;
    public Double price;
    public String description;
    public String category;
    public String image;
}