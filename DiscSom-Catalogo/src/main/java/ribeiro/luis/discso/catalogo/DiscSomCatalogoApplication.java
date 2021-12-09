package ribeiro.luis.discso.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscSomCatalogoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.cloud.bootstrap.enabled","true");
		SpringApplication.run(DiscSomCatalogoApplication.class, args);
	}

}
