package com.example.Product.repository;

import com.example.Product.models.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

    // select * from products where name = {name}
    List<Product> findByTitle(String name);

    // select * from products
    List<Product> findAll();

    @Query("select p from  Product p where p.id = :id")
    Product findById(int id);

    // select * from products where category = categort
    List<Product> findAllByCategory(String category);

    List<Product> findAllByTitleLike(String title);

    List<Product> findFirstByTitleAndCategory(String title , String category);

}