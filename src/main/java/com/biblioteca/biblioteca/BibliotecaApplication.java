package com.biblioteca.biblioteca;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	//Bean para conectar DBeaver (herramienta de base de datos externa) a la base de datos H2 en memoria
	//@Bean(initMethod = "start", destroyMethod = "stop")
//	public Server h2Server() throws SQLException {
//		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	//}

}
