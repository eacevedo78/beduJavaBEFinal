package org.bedu.api.servidores.mapper;

import org.bedu.api.servidores.dto.UserDTO;
import org.bedu.api.servidores.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;

@Mapper(componentModel="spring", injectionStrategy=InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserDTO toDTO(User data);
    User toEntity(UserDTO data);
}
