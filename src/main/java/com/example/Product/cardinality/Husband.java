package com.example.Product.cardinality;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Husband {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;
    String name;
    @OneToOne
    Wife w;
}
