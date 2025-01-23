package com.amandazaine.carpostdatastorage.service;

import com.amandazaine.carpostdatastorage.dto.CarPostDTO;

import java.util.List;

public interface CarPostService {
    void createCarPost(CarPostDTO carPostDTO);
    List<CarPostDTO> findAllCarPost();
    CarPostDTO updateCarPost(CarPostDTO carPostDTO, Long carPostId);
    void deleteCarPost(Long carPostId);
}
