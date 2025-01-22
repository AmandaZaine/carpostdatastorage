package com.amandazaine.carpostdatastorage.service.impl;

import com.amandazaine.carpostdatastorage.dto.CarPostDTO;
import com.amandazaine.carpostdatastorage.entity.CarPostEntity;
import com.amandazaine.carpostdatastorage.entity.CarPostOwnerEntity;
import com.amandazaine.carpostdatastorage.repository.CarPostOwnerRepository;
import com.amandazaine.carpostdatastorage.repository.CarPostRepository;
import com.amandazaine.carpostdatastorage.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.amandazaine.carpostdatastorage.dto.CarPostDTO.carPostDtoToCarPostEntity;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    CarPostRepository carPostRepository;

    @Autowired
    CarPostOwnerRepository carPostOwnerRepository;

    @Override
    public void createCarPost(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = carPostDtoToCarPostEntity(carPostDTO);

        carPostOwnerRepository
                .findById(carPostDTO.getOwnerId())
                .ifPresentOrElse(
                        owner -> {carPostEntity.setCarPostOwner(owner);},
                        () -> {throw new RuntimeException();}
                );


        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> findAllCarPost() {
        return carPostRepository
                .findAll()
                .stream()
              //.map(carPostEntity -> CarPostDTO.carPostEntityToCarPostDTO(carPostEntity))
                .map(CarPostDTO::carPostEntityToCarPostDTO)
                .toList();
    }

    @Override
    public void updateCarPost(CarPostDTO carPostDTO, Long carPostId) {
        carPostRepository
                .findById(carPostId)
                .ifPresentOrElse(carPost -> {
                        carPost.setModel(carPostDTO.getModel());
                        carPost.setBrand(carPostDTO.getBrand());
                        carPost.setPrice(carPostDTO.getPrice());
                        carPost.setDescription(carPostDTO.getDescription());
                        carPost.setEngineVersion(carPostDTO.getEngineVersion());
                        carPost.setCity(carPostDTO.getCity());
                        carPost.setCreatedDate(carPostDTO.getCreatedDate());

                        carPostRepository.save(carPost);
                    },
                    () -> {throw new NoSuchElementException();}
                );
    }

    @Override
    public void deleteCarPost(Long carPostId) {
        carPostRepository.deleteById(carPostId);
    }
}
