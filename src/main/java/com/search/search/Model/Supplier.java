package com.search.search.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "supplier")
public class Supplier {

    @UuidGenerator
    @Id
    private String supplierId;

    @NotBlank
    private String companyName;
    @NotBlank
    private String website;
    @NotBlank
    private String location;
    @NotBlank
    private String natureOfBusiness;
    @NotBlank
    private String manufacturingProcesses;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(String manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }
}
