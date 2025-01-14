package es.minsait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServicioEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioEurekaServerApplication.class, args);
	}

}
