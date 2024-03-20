package com.anhTuan.restaurantApp.anhTuan.service;

import com.anhTuan.restaurantApp.anhTuan.model.Restaurant;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRestaurantService {
        Restaurant addRestaurant(Restaurant restaurant);
        void updateRestaunrant(Restaurant restaurant);
        void deleteRestaurant(int restaurantId);
        List<Restaurant>getAll();
        Restaurant  getById(int restaunrantId);

        //derived queries
        List<Restaurant>getByCity(String city);
        List<Restaurant>getByType(String type); // veg or non veg

        //custom queries
        List<Restaurant>getByItemName(String itemName); //dosa
        List<Restaurant>getByCuisine(String cuisine);

        void updateTypeByRestaurantId(Integer id,String type);

        int getCountOfType(String type);
        int getBRestaurantCount(String type);
//        int getCountByType(@Param("type") String type);
        List<Restaurant>getRestaurantByType(@Param("type")String type);
}
