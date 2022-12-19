package org.bedu.api.servidores.dto;

import lombok.Data;
import java.util.Date;
@Data
public class ServerDTO {
    private long id;
    private String ip;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
