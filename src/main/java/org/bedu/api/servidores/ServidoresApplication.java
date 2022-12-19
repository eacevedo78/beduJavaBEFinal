package org.bedu.api.servidores;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ServidoresApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ServidoresApplication.class, args);
	}

	public void run(String args[]){
		log.info("API PARA LA ADMINISTRACION DE CREDENCIALES EN SERVIDORES Y APPS");
	}

}
