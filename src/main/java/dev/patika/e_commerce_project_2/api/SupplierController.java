package dev.patika.e_commerce_project_2.api;

import dev.patika.e_commerce_project_2.business.abstracts.ISupplierService;
import dev.patika.e_commerce_project_2.core.config.modelMapper.IModelMapperService;
import dev.patika.e_commerce_project_2.core.result.ResultData;
import dev.patika.e_commerce_project_2.core.utils.ResultHelper;
import dev.patika.e_commerce_project_2.dto.request.supplier.SupplierSaveRequest;
import dev.patika.e_commerce_project_2.dto.response.supplier.SupplierResponse;
import dev.patika.e_commerce_project_2.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {

    private final ISupplierService supplierService;
    private final IModelMapperService modelMapper;

    public SupplierController(ISupplierService supplierService, IModelMapperService modelMapper) {
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SupplierResponse> save(@Valid @RequestBody SupplierSaveRequest supplierSaveRequest) {
        Supplier saveSupplier = this.modelMapper.forRequest().map(supplierSaveRequest, Supplier.class);
        this.supplierService.save(saveSupplier);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveSupplier, SupplierResponse.class));

    }

}
