package dev.patika.e_commerce_project_2.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {

    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;
}
