package com.amandazaine.carpostdatastorage.repository;

import com.amandazaine.carpostdatastorage.entity.CarPostOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostOwnerRepository extends JpaRepository<CarPostOwnerEntity, Long> {
}
