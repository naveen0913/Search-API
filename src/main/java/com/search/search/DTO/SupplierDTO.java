package com.search.search.DTO;

public class SupplierDTO {
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcesses;
    private int page;
    private int size;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
