package com.amandazaine.carpostdatastorage.service;

import com.amandazaine.carpostdatastorage.dto.CarPostOwnerDTO;

public interface CarPostOwnerService {
    void createCarPostOwner(CarPostOwnerDTO carPostOwnerDTO);
    void deleteCarPostOwner(Long carPostOwnerId);
}
