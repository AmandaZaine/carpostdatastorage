package com.amandazaine.carpostdatastorage.dto;

import com.amandazaine.carpostdatastorage.entity.CarPostEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
@JsonInclude
public class CarPostDTO {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private Long ownerId;

    public CarPostDTO(
            String model,
            String brand,
            Double price,
            String description,
            String engineVersion,
            String city,
            String createdDate,
            Long ownerId) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.engineVersion = engineVersion;
        this.city = city;
        this.createdDate = createdDate;
        this.ownerId = ownerId;
    }

    public CarPostDTO() {
    }

    public static List<List<String>> toListOfString(List<CarPostDTO> carPostDTOList) {
        return carPostDTOList
                .stream()
                .map(carPostDTO -> List.of(
                        carPostDTO.model,
                        carPostDTO.brand,
                        carPostDTO.price.toString(),
                        carPostDTO.description,
                        carPostDTO.engineVersion,
                        carPostDTO.city,
                        carPostDTO.createdDate,
                        carPostDTO.ownerId.toString())
                )
                .toList();
    }

    public static CarPostDTO carPostEntityToCarPostDTO(CarPostEntity carPostEntity) {
        CarPostDTO carPostDTO = new CarPostDTO();
        carPostDTO.setBrand(carPostEntity.getBrand());
        carPostDTO.setCity(carPostEntity.getCity());
        carPostDTO.setModel(carPostEntity.getModel());
        carPostDTO.setDescription(carPostEntity.getDescription());
        carPostDTO.setEngineVersion(carPostEntity.getEngineVersion());
        carPostDTO.setCreatedDate(carPostEntity.getCreatedDate());
        carPostDTO.setPrice(carPostEntity.getPrice());
        carPostDTO.setOwnerId(carPostEntity.getUser().getId());

        return carPostDTO;
    }

    public static CarPostEntity carPostDtoToCarPostEntity(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();
        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setCreatedDate(String.valueOf(LocalDate.now()));

        return carPostEntity;
    }

    /* Getters and setters */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
