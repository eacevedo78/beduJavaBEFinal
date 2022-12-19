package org.bedu.api.servidores.mapper;

import javax.annotation.processing.Generated;
import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.dto.CredentialDTO;
import org.bedu.api.servidores.dto.ServerDTO;
import org.bedu.api.servidores.dto.UserDTO;
import org.bedu.api.servidores.entity.Application;
import org.bedu.api.servidores.entity.Credential;
import org.bedu.api.servidores.entity.Server;
import org.bedu.api.servidores.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T22:31:37-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Private Build)"
)
@Component
public class CredentialMapperImpl implements CredentialMapper {

    @Override
    public CredentialDTO toDTO(Credential data) {
        if ( data == null ) {
            return null;
        }

        CredentialDTO credentialDTO = new CredentialDTO();

        credentialDTO.setId( data.getId() );
        credentialDTO.setUserName( data.getUserName() );
        credentialDTO.setPassword( data.getPassword() );
        credentialDTO.setCreatedAt( data.getCreatedAt() );
        credentialDTO.setUpdatedAt( data.getUpdatedAt() );
        credentialDTO.setApplication( applicationToApplicationDTO( data.getApplication() ) );
        credentialDTO.setUser( userToUserDTO( data.getUser() ) );

        return credentialDTO;
    }

    @Override
    public Credential toEntity(CredentialDTO data) {
        if ( data == null ) {
            return null;
        }

        Credential.CredentialBuilder credential = Credential.builder();

        credential.id( data.getId() );
        credential.userName( data.getUserName() );
        credential.password( data.getPassword() );
        credential.createdAt( data.getCreatedAt() );
        credential.updatedAt( data.getUpdatedAt() );
        credential.user( userDTOToUser( data.getUser() ) );
        credential.application( applicationDTOToApplication( data.getApplication() ) );

        return credential.build();
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

    protected ApplicationDTO applicationToApplicationDTO(Application application) {
        if ( application == null ) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();

        applicationDTO.setId( application.getId() );
        applicationDTO.setName( application.getName() );
        applicationDTO.setVersion( application.getVersion() );
        applicationDTO.setCreatedAt( application.getCreatedAt() );
        applicationDTO.setUpdatedAt( application.getUpdatedAt() );
        applicationDTO.setServer( serverToServerDTO( application.getServer() ) );

        return applicationDTO;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setCreatedAt( user.getCreatedAt() );
        userDTO.setUpdatedAt( user.getUpdatedAt() );

        return userDTO;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDTO.getId() );
        user.name( userDTO.getName() );
        user.lastName( userDTO.getLastName() );
        user.createdAt( userDTO.getCreatedAt() );
        user.updatedAt( userDTO.getUpdatedAt() );

        return user.build();
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

    protected Application applicationDTOToApplication(ApplicationDTO applicationDTO) {
        if ( applicationDTO == null ) {
            return null;
        }

        Application.ApplicationBuilder application = Application.builder();

        application.id( applicationDTO.getId() );
        application.name( applicationDTO.getName() );
        application.version( applicationDTO.getVersion() );
        application.createdAt( applicationDTO.getCreatedAt() );
        application.updatedAt( applicationDTO.getUpdatedAt() );
        application.server( serverDTOToServer( applicationDTO.getServer() ) );

        return application.build();
    }
}
