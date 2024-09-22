package com.example.Product.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_learners")

public class Learners extends Users{

    private String college;
    private String company;
}
