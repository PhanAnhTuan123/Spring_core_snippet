package com.anhTuan.restaurantApp.anhTuan.service;

import com.anhTuan.restaurantApp.anhTuan.model.Restaurant;
import com.anhTuan.restaurantApp.anhTuan.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements  IRestaurantService{

    private IRestaurantRepository repository;
    @Autowired
    public void setRepository(IRestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void updateRestaunrant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        repository.deleteById(restaurantId);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public Restaurant getById(int restaunrantId) {
        Optional<Restaurant>restOpt = repository.findById(restaunrantId);
        if(restOpt.isPresent())
            return restOpt.get();
        return null;
    }

    @Override
    public List<Restaurant> getByCity(String city) {
        return null;
    }

    @Override
    public List<Restaurant> getByType(String type) {
        return null;
    }

    @Override
    public List<Restaurant> getByItemName(String itemName) {
        return null;
    }

    @Override
    public List<Restaurant> getByCuisine(String cuisine) {
        return null;
    }
}
