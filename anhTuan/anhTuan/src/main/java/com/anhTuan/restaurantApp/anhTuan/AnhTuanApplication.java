package com.anhTuan.restaurantApp.anhTuan;

import com.anhTuan.restaurantApp.anhTuan.model.Item;
import com.anhTuan.restaurantApp.anhTuan.model.Restaurant;
import com.anhTuan.restaurantApp.anhTuan.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AnhTuanApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AnhTuanApplication.class, args);
	}
	@Autowired
	private IRestaurantService service;

	@Override
	public void run(String... args) throws Exception {
		Item itemOne = new Item("Dosa","Breakfast","SI",100);
		Item itemTwo = new Item("FriedRice","MainCourse","Chinese",200);
		Item itemThree = new Item("Noodles","SuShi","Japan",200);

		Set<Item>items = new HashSet<>(Arrays.asList(itemOne,itemTwo,itemThree));
		Restaurant restaurant = new Restaurant("Taj","non-veg","Bangalore",items);
		service.addRestaurant(restaurant);
	}
}
