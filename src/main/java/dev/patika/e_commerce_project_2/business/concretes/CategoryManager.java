package dev.patika.e_commerce_project_2.business.concretes;

import dev.patika.e_commerce_project_2.business.abstracts.ICategoryService;
import dev.patika.e_commerce_project_2.core.exception.NotFoundException;
import dev.patika.e_commerce_project_2.core.utils.Msg;
import dev.patika.e_commerce_project_2.dao.CategoryRepo;
import dev.patika.e_commerce_project_2.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId()); // id mevcut değil ise exception verecek
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }
}
