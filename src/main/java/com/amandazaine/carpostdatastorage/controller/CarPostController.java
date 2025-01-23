package com.amandazaine.carpostdatastorage.controller;

import com.amandazaine.carpostdatastorage.dto.CarPostDTO;
import com.amandazaine.carpostdatastorage.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datastorage/carpost")
public class CarPostController {

    @Autowired
    CarPostService carPostService;

    @GetMapping
    public ResponseEntity<List<CarPostDTO>> findAllCarPost() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.findAllCarPost());
    }

    @PutMapping("/{carPostId}")
    public ResponseEntity<CarPostDTO> updateCarPost(@RequestBody CarPostDTO carPostDTO, @PathVariable("carPostId") Long carPostId) {
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.updateCarPost(carPostDTO, carPostId));
    }

    @DeleteMapping("/{carPostId}")
    public ResponseEntity<Long> deleteCarPost(@PathVariable("carPostId") Long carPostId) {
        carPostService.deleteCarPost(carPostId);
        return new ResponseEntity<>(carPostId, HttpStatus.OK);
    }
}
