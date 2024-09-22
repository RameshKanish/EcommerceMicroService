package com.example.Product.dtos;


import lombok.Data;

@Data
public class CreateProductDto {
    public int id;
    public String title;
    public Double price;
    public String description;
    public String category;
    public String image;
}
