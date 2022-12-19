package org.bedu.api.servidores.service.impl;

import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.entity.Application;
import org.bedu.api.servidores.entity.Server;
import org.bedu.api.servidores.mapper.ApplicationMapper;
import org.bedu.api.servidores.repository.IApplicationRepository;
import org.bedu.api.servidores.repository.IServerRepository;
import org.bedu.api.servidores.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationServiceImpl implements IApplicationService {
    private ApplicationMapper mapper;
    private IApplicationRepository repository;
    private IServerRepository serverRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationMapper mapper, IApplicationRepository repository,IServerRepository serverRepository){
        this.mapper=mapper;
        this.repository=repository;
        this.serverRepository=serverRepository;
    }
    @Override
    public List<ApplicationDTO> findAll() {
        List<Application> apps = repository.findAll();
        return apps.stream().map(mapper::toDTO).toList();
    }

    @Override
    public List<ApplicationDTO> findByServerId(long server_id) {
        List<Application> apps = repository.findByServerId(server_id);
        return apps.stream().map(mapper::toDTO).toList();
    }

    @Override
    public ApplicationDTO findById(long id) {
        Application app = repository.findById(id).get();
        return mapper.toDTO(app);
    }

    @Override
    public ApplicationDTO save(long serverId, ApplicationDTO data){
        Application entity = mapper.toEntity(data);
        Server s = serverRepository.findById(serverId).get();
        entity.setServer(s);
        return mapper.toDTO(repository.save(entity));
    }
    @Override
    public void update(long serverId, long id, ApplicationDTO data) {
        Application entity = repository.findById(id).get();
        if(data.getVersion()!=null)
            entity.setVersion(data.getVersion());
        if(data.getName()!=null)
            entity.setName(data.getName());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
