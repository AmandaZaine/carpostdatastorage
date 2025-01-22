package com.amandazaine.carpostdatastorage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude
public class CarPostOwnerDTO {

    private String name;
    private String type;
    private String contactNumber;

    public CarPostOwnerDTO() {
    }

    public CarPostOwnerDTO(String name, String type, String contactNumber) {
        this.name = name;
        this.type = type;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
