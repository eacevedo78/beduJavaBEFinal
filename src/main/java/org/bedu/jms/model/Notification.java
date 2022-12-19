package org.bedu.jms.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification /*implements Serializable*/ {
    //private static final long serialVersionUID = 1L;
    private String user;
    private String application;
}
