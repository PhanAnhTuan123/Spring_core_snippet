package com.anhTuan.restaurantApp.anhTuan.repository;

import com.anhTuan.restaurantApp.anhTuan.model.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {

    @Query("from Restaurant r where r.type = 'non-veg' or r.type = 'Non vaix' ")
    List<Restaurant>getByType(String type);

    // Native Query - use native sql - use table name and column names
    @Query(value = "select  * from Restaurant r where r.type like 'non-veg'",nativeQuery = true)
     List<Restaurant>getByRestaurant(String type);
    // NamedQuery
    @Query(name = "Restaurant.showByType")
    List<Restaurant>findByType(String type);

    @Modifying
    @Transactional
    @Query("update Restaurant r set r.type = :type where r.restaurantId = :id")
    void updateRestauraunt(@Param("id") Integer restaurantId,@Param("type") String type);
}
