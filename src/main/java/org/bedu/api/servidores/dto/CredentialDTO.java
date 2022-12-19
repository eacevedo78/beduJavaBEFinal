package org.bedu.api.servidores.dto;
import lombok.Data;
import java.util.Date;

@Data
public class CredentialDTO {
    private long id;
    private String userName;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private ApplicationDTO application;
    private UserDTO user;
}
