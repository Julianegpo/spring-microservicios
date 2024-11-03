package es.minsait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import es.minsait.persistence.ShoppingCartsDAO;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MicroServicioCarritoEurekaApplication implements CommandLineRunner{
	
	@Autowired
	private ShoppingCartsDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioCarritoEurekaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// eliminamos todos los carritos
		dao.deleteAll();
	}

}
