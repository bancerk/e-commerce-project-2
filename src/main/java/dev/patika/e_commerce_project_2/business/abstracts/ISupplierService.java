package dev.patika.e_commerce_project_2.business.abstracts;

import dev.patika.e_commerce_project_2.entities.Supplier;
import org.springframework.data.domain.Page;

public interface ISupplierService {

    Supplier save(Supplier supplier);

    Supplier get(int id);

    Page<Supplier> cursor(int page, int pageSize);

    Supplier update(Supplier supplier);

    boolean delete(int id);

}
