package com.formaciondbi.microservicios.cursos3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formaciondbi.microservicios.generics.models.entity",
			"com.formaciondbi.microservicios.generics.examenes",
			"com.formaciondbi.microservicios.cursos3.entity"})
public class MicroserviciosCursos3Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursos3Application.class, args);
	}

}
