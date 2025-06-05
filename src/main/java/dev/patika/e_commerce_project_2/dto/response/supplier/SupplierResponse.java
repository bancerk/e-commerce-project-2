package dev.patika.e_commerce_project_2.dto.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponse {

    private int id;
    private String companyName;
}
