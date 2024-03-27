package dev.anhTuan.springConfigFileV2;

import dev.anhTuan.springConfigFileV2.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class SpringConfigFileV2Application implements CommandLineRunner {
	private final PizzaConfig pizzaConfig;

    public SpringConfigFileV2Application(PizzaConfig pizzaConfig) {
        this.pizzaConfig = pizzaConfig;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringConfigFileV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info(
				String.format("I want a %s crust pizza,with %s and %s sauce",
				pizzaConfig.getCrust(),
				pizzaConfig.getTopping(),
				pizzaConfig.getSauce()
				)
		);
	}
}
