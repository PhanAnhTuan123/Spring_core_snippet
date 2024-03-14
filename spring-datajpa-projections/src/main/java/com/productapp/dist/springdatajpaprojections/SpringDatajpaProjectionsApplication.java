package com.productapp.dist.springdatajpaprojections;

import com.productapp.dist.springdatajpaprojections.model.Product;
import com.productapp.dist.springdatajpaprojections.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDatajpaProjectionsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaProjectionsApplication.class, args);
	}


	private IProductService iProductService;

	@Autowired
	public void setiProductService(IProductService iProductService) {
		this.iProductService = iProductService;
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product("RIs",54.000,"Luis vuiton","coast");
		Product p2 = new Product("buiz",69.000,"Calvin Klein","slim-fit jean");
		Product p3 = new Product("con",991.000,"Christon Dior","T-shirt");
		Product p4 = new Product("Bag of ninja",230.000,"Parada","bag");
		Product p5 = new Product("Coina",544.000,"Gucci","pants");
//		iProductService.addProduct(p1);
		iProductService.addProduct(p2);
		iProductService.addProduct(p3);
		iProductService.addProduct(p4);
		iProductService.addProduct(p5);
		System.out.println("Completed!!!");
	}
}
