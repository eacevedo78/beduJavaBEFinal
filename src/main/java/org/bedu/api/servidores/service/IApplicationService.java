package org.bedu.api.servidores.service;

import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.entity.Application;

import java.util.List;
import java.util.Optional;

public interface IApplicationService {
    List<ApplicationDTO> findAll();

    List<ApplicationDTO> findByServerId(long server_id);
    ApplicationDTO findById(long id);

    ApplicationDTO save(long serverId, ApplicationDTO data);
    void update(long serverId, long id,ApplicationDTO data);
    void delete(long id);
}
