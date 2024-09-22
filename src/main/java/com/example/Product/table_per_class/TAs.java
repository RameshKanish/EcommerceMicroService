package com.example.Product.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_tas")

public class TAs extends Users{
    private int numOfQuestions;
    private String college;

}
