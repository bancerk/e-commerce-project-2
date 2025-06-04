package dev.patika.e_commerce_project_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("dev.patika.e_commerce_project_2")
public class ECommerceProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceProject2Application.class, args);
	}

}
