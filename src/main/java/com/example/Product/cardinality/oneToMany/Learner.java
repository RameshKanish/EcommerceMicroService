package com.example.Product.cardinality.oneToMany;

import jakarta.persistence.*;


@Entity
public class Learner {
    @Id
    long id;
    String name;
}
