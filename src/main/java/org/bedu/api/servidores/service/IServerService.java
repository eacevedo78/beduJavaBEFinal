package org.bedu.api.servidores.service;

import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.dto.ServerDTO;

import java.util.List;
import java.util.Optional;

public interface IServerService {

    List<ServerDTO> findAll();
    ServerDTO findById(long id);
    ServerDTO save(ServerDTO data);
    void update(long id,ServerDTO data);
    void delete(long id);
}
