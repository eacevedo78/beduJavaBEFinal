package org.bedu.api.servidores.service.impl;

import org.bedu.api.servidores.dto.ServerDTO;
import org.bedu.api.servidores.entity.Server;
import org.bedu.api.servidores.mapper.ServerMapper;
import org.bedu.api.servidores.repository.IServerRepository;
import org.bedu.api.servidores.service.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements IServerService {
    private ServerMapper mapper;
    private IServerRepository repository;

    @Autowired
    public ServerServiceImpl(ServerMapper mapper, IServerRepository repository){
        this.mapper=mapper;
        this.repository=repository;
    }
    @Override
    public List<ServerDTO> findAll() {
        List<Server> servers = repository.findAll();
        return servers.stream().map(mapper::toDTO).toList();
    }

    @Override
    public ServerDTO findById(long id) {
        return mapper.toDTO(repository.findById(id).get());
    }

    @Override
    public ServerDTO save(ServerDTO data){
        Server entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void update(long id, ServerDTO data) {
        Server entity = repository.findById(id).get();
        if(data.getIp()!=null)
            entity.setIp(data.getIp());
        if(data.getName()!=null)
            entity.setName(data.getName());
        if(data.getDescription()!=null)
            entity.setDescription(data.getDescription());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
