package com.example.Product.mapped_super_class;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Users {
    @Id
    private int id;
    private String email;
    private String name;
    private String password;
}
