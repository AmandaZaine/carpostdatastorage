package com.amandazaine.carpostdatastorage.repository;

import com.amandazaine.carpostdatastorage.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {

}
