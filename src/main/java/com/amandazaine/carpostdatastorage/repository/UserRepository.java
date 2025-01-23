package com.amandazaine.carpostdatastorage.repository;

import com.amandazaine.carpostdatastorage.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
