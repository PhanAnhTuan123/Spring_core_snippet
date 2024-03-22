package dev.anhTuan.flyway;

import dev.anhTuan.flyway.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlywayApplication implements CommandLineRunner {

	private final BookRepository repository;

    public FlywayApplication(BookRepository repository) {
        this.repository = repository;
    }


    public static void main(String[] args) {
		SpringApplication.run(FlywayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.findAll().forEach(book -> {
			System.out.println(book
					.toString());

		});
	}
}
