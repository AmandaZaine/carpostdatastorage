package com.amandazaine.carpostdatastorage.service.impl;

import com.amandazaine.carpostdatastorage.dto.UserDTO;
import com.amandazaine.carpostdatastorage.entity.UserEntity;
import com.amandazaine.carpostdatastorage.repository.UserRepository;
import com.amandazaine.carpostdatastorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setType(userDTO.getType());
        userEntity.setPhone(userDTO.getPhone());

        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
