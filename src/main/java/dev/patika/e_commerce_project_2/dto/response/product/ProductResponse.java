package dev.patika.e_commerce_project_2.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;
}
