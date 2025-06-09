package dev.patika.e_commerce_project_2.dao;

import dev.patika.e_commerce_project_2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
