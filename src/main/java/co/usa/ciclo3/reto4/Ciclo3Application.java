package co.usa.ciclo3.reto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.ciclo3.reto4.model"})
@SpringBootApplication
public class Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
