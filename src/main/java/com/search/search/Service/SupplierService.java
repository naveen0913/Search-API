package com.search.search.Service;

import com.search.search.DTO.AddSupplierDTO;
import com.search.search.Model.Supplier;
import com.search.search.Repository.SupplierRepository;
import com.search.search.Responses.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(String location, String natureOfBusiness, String manufacturingProcesses) {
        List<Supplier> suppliers = supplierRepository.findSuppliersByCriteria(location, natureOfBusiness, manufacturingProcesses);

        if (suppliers.isEmpty()){
            throw new RuntimeException("Suppliers data not available");
        }
        return suppliers;
    }

    public ResponseEntity<?> addNewSupplier(AddSupplierDTO addSupplierDTO){
        Supplier newSupplier = new Supplier();
        newSupplier.setCompanyName(addSupplierDTO.getCompanyName());
        newSupplier.setLocation(addSupplierDTO.getLocation());
        newSupplier.setWebsite(addSupplierDTO.getWebsite());
        newSupplier.setNatureOfBusiness(addSupplierDTO.getNatureOfBusiness());
        newSupplier.setManufacturingProcesses(addSupplierDTO.getManufacturingProcesses());
        supplierRepository.save(newSupplier);
        return ResponseEntity.ok(new CustomResponse(HttpStatus.CREATED.value(), "created",null));
    }

    public ResponseEntity<?> getSupplierById(String uuid){
        Optional<Supplier> existedSupplier = supplierRepository.findById(uuid);
        if (existedSupplier.isEmpty()){
            return ResponseEntity.badRequest().body(new CustomResponse(HttpStatus.NOT_FOUND.value(),"unavailable",null));
        }else{
            return ResponseEntity.ok().body(new CustomResponse(HttpStatus.OK.value(), "ok",existedSupplier));
        }
    }

    public ResponseEntity<?> updateSupplierData(String id,Supplier supplier){

        Optional<Supplier> existedSupplier = supplierRepository.findById(id);
        if (existedSupplier.isEmpty()){
            return ResponseEntity.badRequest().body(new CustomResponse(HttpStatus.NOT_FOUND.value(),"unavailable",null));
        }

        Supplier updateSupplier = existedSupplier.get();
        updateSupplier.setCompanyName(supplier.getCompanyName());
        updateSupplier.setManufacturingProcesses(supplier.getManufacturingProcesses());
        updateSupplier.setLocation(supplier.getLocation());
        updateSupplier.setWebsite(supplier.getWebsite());
        updateSupplier.setNatureOfBusiness(supplier.getNatureOfBusiness());
        supplierRepository.save(updateSupplier);
        return ResponseEntity.ok().body(new CustomResponse(HttpStatus.OK.value(), "updated",updateSupplier));

    }

    public ResponseEntity<?> deleteSupplier(String Id){
        Optional<Supplier> existedSupplier = supplierRepository.findById(Id);
        if (existedSupplier.isEmpty()){
            return ResponseEntity.badRequest().body(new CustomResponse(HttpStatus.NOT_FOUND.value(),"unavailable",null));
        }else{
            return ResponseEntity.ok().body(new CustomResponse(HttpStatus.OK.value(), "deleted",null));
        }
    }

}
