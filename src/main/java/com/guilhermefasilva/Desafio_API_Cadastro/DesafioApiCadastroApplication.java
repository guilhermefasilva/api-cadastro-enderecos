package com.guilhermefasilva.Desafio_API_Cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioApiCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiCadastroApplication.class, args);
	}

}
