package dev.patika.e_commerce_project_2.api;

import dev.patika.e_commerce_project_2.business.abstracts.ICategoryService;
import dev.patika.e_commerce_project_2.business.abstracts.IProductService;
import dev.patika.e_commerce_project_2.business.abstracts.ISupplierService;
import dev.patika.e_commerce_project_2.core.config.modelMapper.IModelMapperService;
import dev.patika.e_commerce_project_2.core.result.ResultData;
import dev.patika.e_commerce_project_2.core.utils.ResultHelper;
import dev.patika.e_commerce_project_2.dto.request.product.ProductSaveRequest;
import dev.patika.e_commerce_project_2.dto.response.CursorResponse;
import dev.patika.e_commerce_project_2.dto.response.product.ProductResponse;
import dev.patika.e_commerce_project_2.entities.Category;
import dev.patika.e_commerce_project_2.entities.Product;
import dev.patika.e_commerce_project_2.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final IProductService productService;
    private IModelMapperService modelMapper;
    private final ICategoryService categoryService;
    private final ISupplierService supplierService;

    public ProductController(
            IProductService productService,
            IModelMapperService modelMapper,
            ICategoryService categoryService,
            ISupplierService supplierService) {

        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        Product saveProduct = this.modelMapper.forRequest().map(productSaveRequest, Product.class);

        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        saveProduct.setCategory(category);

        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
        saveProduct.setSupplier(supplier);

        this.productService.save(saveProduct);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveProduct, ProductResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> get(@PathVariable("id") int id) {
        Product product = this.productService.get(id);
        ProductResponse productResponse = this.modelMapper.forResponse().map(product, ProductResponse.class);
        return ResultHelper.success(productResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<ProductResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Product> productPage = this.productService.cursor(page, pageSize);
        Page<ProductResponse> productResponsePage = productPage
                .map(product -> this.modelMapper.forResponse().map(product, ProductResponse.class));

        return ResultHelper.cursor(productResponsePage);
    }
}
