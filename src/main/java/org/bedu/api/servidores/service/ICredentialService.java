package org.bedu.api.servidores.service;

import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.dto.CredentialDTO;

import java.util.List;
import java.util.Optional;
public interface ICredentialService {
    List<CredentialDTO> findAll();

    List<CredentialDTO> findByUserId(long userId);
    CredentialDTO findById(long id);
    CredentialDTO save(long userId,long applicationId,CredentialDTO data);
    void update(long userId, long applicationId, long id,CredentialDTO data);
    void delete(long id);
}
