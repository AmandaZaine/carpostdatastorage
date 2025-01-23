package com.amandazaine.carpostdatastorage.service;

import com.amandazaine.carpostdatastorage.dto.UserDTO;

public interface UserService {
    void createUser(UserDTO userDTO);
    void deleteUser(Long userId);
}
