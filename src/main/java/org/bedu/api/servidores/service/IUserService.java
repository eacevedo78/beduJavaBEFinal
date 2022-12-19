package org.bedu.api.servidores.service;

import org.bedu.api.servidores.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> findAll();
    UserDTO findById(long id);
    UserDTO save(UserDTO data);
    void update(long id,UserDTO data);
    void delete(long id);
}
