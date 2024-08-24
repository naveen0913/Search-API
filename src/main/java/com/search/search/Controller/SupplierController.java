package com.search.search.Controller;

import com.search.search.DTO.AddSupplierDTO;
import com.search.search.DTO.SupplierDTO;
import com.search.search.Model.Supplier;
import com.search.search.Service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/supplier/")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("query")
    public Page<Supplier> querySuppliers(@RequestParam(required = false) String location,
                                                         @RequestParam(required = false) String natureOfBusiness,
                                                         @RequestParam(required = false) String manufacturingProcesses,
                                         @RequestParam(required = true,defaultValue = "0") int pageNumber,@RequestParam (required = true,defaultValue = "9")int size)
    {
        return  supplierService.getSuppliers(location,natureOfBusiness,manufacturingProcesses,pageNumber,size);

    }

    @PostMapping("query")
    public ResponseEntity<?> addNewSupplierData(@Valid @RequestBody AddSupplierDTO supplierDTO){
        return supplierService.addNewSupplier(supplierDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable String id){
        return supplierService.getSupplierById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable String id,@Valid @RequestBody Supplier supplier){
        return supplierService.updateSupplierData(id,supplier);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        return supplierService.deleteSupplier(id);
    }

}
