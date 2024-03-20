package com.anhTuan.restaurantApp.anhTuan.repository;

import com.anhTuan.restaurantApp.anhTuan.model.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

    // use procedure name as the method name
    @Procedure
    int get_count_of_type(String type);

    //Using @Procedure with different method name.
    //Use attributes to pass procedureName
    @Procedure(procedureName = "get_count_of_type")
    int getCountType(String type);

    //Using @NamedStoredProcedureQuery annotation
    @Procedure(name = "getRestaurantByType")
    int getCountByType(@Param("type") String type);

    //Using @Query annotation
    @Query(value = "call get_restaurant_by_type(:type)",nativeQuery = true)
    List<Restaurant> getRestaurantByType(@Param("type") String type);
}
