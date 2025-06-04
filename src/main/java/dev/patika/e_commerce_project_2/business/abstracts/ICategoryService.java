package dev.patika.e_commerce_project_2.business.abstracts;


import dev.patika.e_commerce_project_2.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {

    Category save(Category category);

    Category get(int id);

    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    boolean delete (int id);

}
