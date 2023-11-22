package br.com.fiap;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@SecurityScheme(
		name = "Bearer Authentication",
		scheme = "bearer",
		bearerFormat = "JWT",
		type = SecuritySchemeType.HTTP
)
@EnableCaching
public class ApiGlobalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGlobalApplication.class, args);
	}

}
