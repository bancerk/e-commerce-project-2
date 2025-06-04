package dev.patika.e_commerce_project_2.api;

import dev.patika.e_commerce_project_2.business.abstracts.ICategoryService;
import dev.patika.e_commerce_project_2.core.config.modelMapper.IModelMapperService;
import dev.patika.e_commerce_project_2.core.result.ResultData;
import dev.patika.e_commerce_project_2.core.utils.ResultHelper;
import dev.patika.e_commerce_project_2.dto.request.category.CategorySaveRequest;
import dev.patika.e_commerce_project_2.dto.response.category.CategoryResponse;
import dev.patika.e_commerce_project_2.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class));
    }
}
