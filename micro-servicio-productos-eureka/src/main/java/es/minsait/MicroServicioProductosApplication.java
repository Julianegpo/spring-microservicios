package es.minsait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioProductosApplication.class, args);
	}

}
