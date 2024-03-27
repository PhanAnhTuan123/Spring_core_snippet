package dev.anhTuan.demo.Spring;

import dev.anhTuan.demo.Spring.services.ColourPrinter;
import dev.anhTuan.demo.Spring.services.impl.ColurPrinterImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ColoursApplication implements CommandLineRunner {

	private ColourPrinter colourPrinter;

	public ColoursApplication(ColourPrinter colourPrinter) {
		this.colourPrinter = colourPrinter;
	}

	public static void main(String[] args) {
		SpringApplication.run(ColoursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(colourPrinter.print());

	}
}
