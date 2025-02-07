package com.amandazaine.carpostdatastorage.service.impl;

import com.amandazaine.carpostdatastorage.dto.CarPostDTO;
import com.amandazaine.carpostdatastorage.entity.CarPostEntity;
import com.amandazaine.carpostdatastorage.repository.UserRepository;
import com.amandazaine.carpostdatastorage.repository.CarPostRepository;
import com.amandazaine.carpostdatastorage.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

import static com.amandazaine.carpostdatastorage.dto.CarPostDTO.carPostDtoToCarPostEntity;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    CarPostRepository carPostRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void createCarPost(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = carPostDtoToCarPostEntity(carPostDTO);

        userRepository
                .findById(carPostDTO.getOwnerId())
                .ifPresentOrElse(
                        owner -> {carPostEntity.setUser(owner);},
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
    public CarPostDTO updateCarPost(CarPostDTO carPostDTO, Long carPostId) {
        AtomicReference<CarPostEntity> carPostAtualizado = new AtomicReference<>();

        carPostRepository
                .findById(carPostId)
                .ifPresentOrElse(
                        carPostEntity -> {
                            if(!carPostDTO.getModel().isEmpty() && !carPostDTO.getModel().isBlank()) {
                                carPostEntity.setModel(carPostDTO.getModel());
                            }

                            if(!carPostDTO.getBrand().isEmpty() && !carPostDTO.getBrand().isBlank()) {
                                carPostEntity.setBrand(carPostDTO.getBrand());
                            }

                            if(!carPostDTO.getPrice().equals(0d) && carPostDTO.getPrice() != null) {
                                carPostEntity.setPrice(carPostDTO.getPrice());
                            }

                            if(!carPostDTO.getDescription().isEmpty() && !carPostDTO.getDescription().isBlank()) {
                                carPostEntity.setDescription(carPostDTO.getDescription());
                            }

                            if(!carPostDTO.getEngineVersion().isEmpty() && !carPostDTO.getEngineVersion().isBlank()) {
                                carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
                            }

                            if(!carPostDTO.getCity().isEmpty() && !carPostDTO.getCity().isBlank()) {
                                carPostEntity.setCity(carPostDTO.getCity());
                            }

                            if(!carPostDTO.getCreatedDate().isEmpty() && !carPostDTO.getCreatedDate().isBlank()) {
                                carPostEntity.setCreatedDate(carPostDTO.getCreatedDate());
                            }

                            //TODO Permitir alterar o owner do post

                            carPostAtualizado.set(carPostRepository.save(carPostEntity));
                        },
                        () -> {
                            throw new NoSuchElementException();
                        }
                );

        return CarPostDTO.carPostEntityToCarPostDTO(carPostAtualizado.get());
    }

    @Override
    public void deleteCarPost(Long carPostId) {
        carPostRepository.deleteById(carPostId);
    }
}
