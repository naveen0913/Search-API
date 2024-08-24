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

    @GetMapping("/query")
    public List<Supplier> querySuppliers(@RequestParam(required = false) String location,
                                                         @RequestParam(required = false) String natureOfBusiness,
                                                         @RequestParam(required = false) String manufacturingProcesses,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "5") int size) {
//        Page<Supplier> suppliers = (Page<Supplier>) supplierService.getSuppliers(location, natureOfBusiness, manufacturingProcesses, page, size);
        return  supplierService.getSuppliers(location,natureOfBusiness,manufacturingProcesses,page,size);

    }

    @PostMapping("add")
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
