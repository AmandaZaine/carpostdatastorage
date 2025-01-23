package com.amandazaine.carpostdatastorage.service.impl;

import com.amandazaine.carpostdatastorage.dto.CarPostOwnerDTO;
import com.amandazaine.carpostdatastorage.entity.CarPostOwnerEntity;
import com.amandazaine.carpostdatastorage.repository.CarPostOwnerRepository;
import com.amandazaine.carpostdatastorage.service.CarPostOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarPostOwnerServiceImpl implements CarPostOwnerService {

    @Autowired
    CarPostOwnerRepository carPostOwnerRepository;

    @Override
    public void createCarPostOwner(CarPostOwnerDTO carPostOwnerDTO) {
        CarPostOwnerEntity carPostOwnerEntity = new CarPostOwnerEntity();
        carPostOwnerEntity.setName(carPostOwnerDTO.getName());
        carPostOwnerEntity.setType(carPostOwnerDTO.getType());
        carPostOwnerEntity.setPhone(carPostOwnerDTO.getPhone());

        carPostOwnerRepository.save(carPostOwnerEntity);
    }

    @Override
    public void deleteCarPostOwner(Long carPostOwnerId) {
        carPostOwnerRepository.deleteById(carPostOwnerId);
    }
}
