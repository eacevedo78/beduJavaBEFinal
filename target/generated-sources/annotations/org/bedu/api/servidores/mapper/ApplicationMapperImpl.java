package org.bedu.api.servidores.mapper;

import javax.annotation.processing.Generated;
import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.dto.ServerDTO;
import org.bedu.api.servidores.entity.Application;
import org.bedu.api.servidores.entity.Server;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T22:31:37-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Private Build)"
)
@Component
public class ApplicationMapperImpl implements ApplicationMapper {

    @Override
    public ApplicationDTO toDTO(Application data) {
        if ( data == null ) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();

        applicationDTO.setId( data.getId() );
        applicationDTO.setName( data.getName() );
        applicationDTO.setVersion( data.getVersion() );
        applicationDTO.setCreatedAt( data.getCreatedAt() );
        applicationDTO.setUpdatedAt( data.getUpdatedAt() );
        applicationDTO.setServer( serverToServerDTO( data.getServer() ) );

        return applicationDTO;
    }

    @Override
    public Application toEntity(ApplicationDTO data) {
        if ( data == null ) {
            return null;
        }

        Application.ApplicationBuilder application = Application.builder();

        application.id( data.getId() );
        application.name( data.getName() );
        application.version( data.getVersion() );
        application.createdAt( data.getCreatedAt() );
        application.updatedAt( data.getUpdatedAt() );
        application.server( serverDTOToServer( data.getServer() ) );

        return application.build();
    }

    protected ServerDTO serverToServerDTO(Server server) {
        if ( server == null ) {
            return null;
        }

        ServerDTO serverDTO = new ServerDTO();

        serverDTO.setId( server.getId() );
        serverDTO.setIp( server.getIp() );
        serverDTO.setName( server.getName() );
        serverDTO.setDescription( server.getDescription() );
        serverDTO.setCreatedAt( server.getCreatedAt() );
        serverDTO.setUpdatedAt( server.getUpdatedAt() );

        return serverDTO;
    }

    protected Server serverDTOToServer(ServerDTO serverDTO) {
        if ( serverDTO == null ) {
            return null;
        }

        Server.ServerBuilder server = Server.builder();

        server.id( serverDTO.getId() );
        server.ip( serverDTO.getIp() );
        server.name( serverDTO.getName() );
        server.description( serverDTO.getDescription() );
        server.createdAt( serverDTO.getCreatedAt() );
        server.updatedAt( serverDTO.getUpdatedAt() );

        return server.build();
    }
}
