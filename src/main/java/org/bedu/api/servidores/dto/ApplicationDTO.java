package org.bedu.api.servidores.dto;
import lombok.Data;
import java.util.Date;

@Data
public class ApplicationDTO {
    private long id;
    private String name;
    private String version;
    private Date createdAt;
    private Date updatedAt;
    private ServerDTO server;
}
