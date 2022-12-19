package org.bedu.api.servidores.service.impl;

import org.bedu.api.servidores.dto.UserDTO;
import org.bedu.api.servidores.entity.Server;
import org.bedu.api.servidores.entity.User;
import org.bedu.api.servidores.mapper.UserMapper;
import org.bedu.api.servidores.repository.IUserRepository;
import org.bedu.api.servidores.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private UserMapper mapper;
    private IUserRepository repository;

    @Autowired
    public UserServiceImpl(UserMapper mapper, IUserRepository repository){
        this.mapper=mapper;
        this.repository=repository;
    }
    @Override
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(mapper::toDTO).toList();
    }

    @Override
    public UserDTO findById(long id) {
        return mapper.toDTO(repository.findById(id).get());
    }

    @Override
    public UserDTO save(UserDTO data){
        User entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void update(long id, UserDTO data) {
        User entity = repository.findById(id).get();
        if(data.getName()!=null)
            entity.setName(data.getName());
        if(data.getLastName()!=null)
            entity.setLastName(data.getLastName());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);

    }
}
