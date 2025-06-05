package dev.patika.e_commerce_project_2.dao;

import dev.patika.e_commerce_project_2.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
}
