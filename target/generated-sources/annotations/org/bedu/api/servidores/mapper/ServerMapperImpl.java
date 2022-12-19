package org.bedu.api.servidores.mapper;

import javax.annotation.processing.Generated;
import org.bedu.api.servidores.dto.ServerDTO;
import org.bedu.api.servidores.entity.Server;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T22:31:37-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Private Build)"
)
@Component
public class ServerMapperImpl implements ServerMapper {

    @Override
    public ServerDTO toDTO(Server data) {
        if ( data == null ) {
            return null;
        }

        ServerDTO serverDTO = new ServerDTO();

        serverDTO.setId( data.getId() );
        serverDTO.setIp( data.getIp() );
        serverDTO.setName( data.getName() );
        serverDTO.setDescription( data.getDescription() );
        serverDTO.setCreatedAt( data.getCreatedAt() );
        serverDTO.setUpdatedAt( data.getUpdatedAt() );

        return serverDTO;
    }

    @Override
    public Server toEntity(ServerDTO data) {
        if ( data == null ) {
            return null;
        }

        Server.ServerBuilder server = Server.builder();

        server.id( data.getId() );
        server.ip( data.getIp() );
        server.name( data.getName() );
        server.description( data.getDescription() );
        server.createdAt( data.getCreatedAt() );
        server.updatedAt( data.getUpdatedAt() );

        return server.build();
    }
}
