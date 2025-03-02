package me.dio.service;

import me.dio.dto.UserDTO;

public interface UserService {

    UserDTO findById(Long id);

    UserDTO create(UserDTO userToCreate);

    UserDTO update(Long id, UserDTO userToUpdate);

    void delete(Long id);

}
