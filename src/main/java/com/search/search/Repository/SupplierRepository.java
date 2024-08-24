package com.search.search.Repository;

import com.search.search.Model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,String> {

    @Query("SELECT s FROM Supplier s WHERE " +
            "(:location IS NULL OR s.location LIKE %:location%) AND " +
            "(:natureOfBusiness IS NULL OR s.natureOfBusiness LIKE %:natureOfBusiness%) AND " +
            "(:manufacturingProcesses IS NULL OR s.manufacturingProcesses LIKE %:manufacturingProcesses%)")
    Page<Supplier> findSuppliersByCriteria(@Param("location") String location,
                                           @Param("natureOfBusiness") String natureOfBusiness,
                                           @Param("manufacturingProcesses") String process,Pageable pageable);
}
