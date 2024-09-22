package com.example.Product.joined_table;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_learners")
@PrimaryKeyJoinColumn(name = "users_id")

public class Learner extends Users{
    private String college;
    private String company;
}
