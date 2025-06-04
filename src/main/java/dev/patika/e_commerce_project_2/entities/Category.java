package dev.patika.e_commerce_project_2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // PostgreSQL fails to initiate db table with GenerationType.IDENTITY and columnDefinition = "serial"
    @Column(name = "category_id", columnDefinition = "serial")
    private int id;

    @NotNull
    @Column(name = "category_name")
    private String name;


}
