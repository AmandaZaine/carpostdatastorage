package com.amandazaine.carpostdatastorage.controller;

import com.amandazaine.carpostdatastorage.dto.CarPostOwnerDTO;
import com.amandazaine.carpostdatastorage.service.CarPostOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/datastorage/carpostowner")
public class CarPostOwnerController {

    @Autowired
    CarPostOwnerService carPostOwnerService;

    @PostMapping
    public ResponseEntity createCarPostOwner(@RequestBody CarPostOwnerDTO carPostOwnerDTO) {
        carPostOwnerService.createCarPostOwner(carPostOwnerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{carPostOwnerId}")
    public ResponseEntity deleteCarPostOwner(@PathVariable("carPostOwnerId") Long carPostOwnerId) {
        carPostOwnerService.deleteCarPostOwner(carPostOwnerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
