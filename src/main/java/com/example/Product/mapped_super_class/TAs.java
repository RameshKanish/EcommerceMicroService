package com.example.Product.mapped_super_class;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_tas")
public class TAs extends Users{

    private int numOfQuestions;
    private String college;
}