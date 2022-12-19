package org.bedu.api.servidores.mapper;

import javax.annotation.processing.Generated;
import org.bedu.api.servidores.dto.UserDTO;
import org.bedu.api.servidores.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T22:31:37-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User data) {
        if ( data == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( data.getId() );
        userDTO.setName( data.getName() );
        userDTO.setLastName( data.getLastName() );
        userDTO.setCreatedAt( data.getCreatedAt() );
        userDTO.setUpdatedAt( data.getUpdatedAt() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO data) {
        if ( data == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( data.getId() );
        user.name( data.getName() );
        user.lastName( data.getLastName() );
        user.createdAt( data.getCreatedAt() );
        user.updatedAt( data.getUpdatedAt() );

        return user.build();
    }
}
