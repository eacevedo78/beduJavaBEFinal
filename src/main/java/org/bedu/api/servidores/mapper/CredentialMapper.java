package org.bedu.api.servidores.mapper;

import org.bedu.api.servidores.dto.CredentialDTO;
import org.bedu.api.servidores.entity.Credential;
import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;

@Mapper(componentModel="spring", injectionStrategy=InjectionStrategy.CONSTRUCTOR)
public interface CredentialMapper {

    CredentialDTO toDTO(Credential data);
    Credential toEntity(CredentialDTO data);
}
