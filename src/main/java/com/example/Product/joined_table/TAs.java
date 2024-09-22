package com.example.Product.joined_table;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity(name = "jt_TAs")
@Data
@PrimaryKeyJoinColumn(name = "users_id")

public class TAs extends Users{
    private int numOfQuestions;
    private String college;
}