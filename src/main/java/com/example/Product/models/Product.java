package com.example.Product.models;


import lombok.Data;

@Data
public class Product {
    public int id;
    public String title;
    public Double price;
    public String description;
    public String category;
    public String image;

}