package org.bedu.api.servidores.mapper;

import org.bedu.api.servidores.dto.ServerDTO;
import org.bedu.api.servidores.entity.Server;
import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
@Mapper(componentModel="spring", injectionStrategy=InjectionStrategy.CONSTRUCTOR)
public interface ServerMapper {
    ServerDTO toDTO(Server data);
    Server toEntity(ServerDTO data);
}
