package com.example.Product.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_mentors")
@PrimaryKeyJoinColumn(name = "users_id")

public class Mentors extends Users{
    private double avg_rating;
    private String currentComapny;
}