package dev.patika.e_commerce_project_2.dao;

import dev.patika.e_commerce_project_2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
