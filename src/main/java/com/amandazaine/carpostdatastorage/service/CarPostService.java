package com.amandazaine.carpostdatastorage.service;

import com.amandazaine.carpostdatastorage.dto.CarPostDTO;

import java.util.List;

public interface CarPostService {
    void createCarPost(CarPostDTO carPostDTO);
    List<CarPostDTO> findAllCarPost();
    void updateCarPost(CarPostDTO carPostDTO, Long carPostId);
    void deleteCarPost(Long carPostId);
}
