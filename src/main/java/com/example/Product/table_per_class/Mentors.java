package com.example.Product.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_mentors")

public class Mentors extends Users{
    private double avg_rating;
    private String currentComapny;
}