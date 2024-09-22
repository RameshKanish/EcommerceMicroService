package com.example.Product.mapped_super_class;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_mentors")

public class Mentors extends Users{
    private double avg_rating;
    private String currentComapny;
}
