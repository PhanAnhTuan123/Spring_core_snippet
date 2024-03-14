package com.productapp.dist.springdatajpaprojections.repository;

import com.productapp.dist.springdatajpaprojections.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {


//     select productname,price from product where brand=?1
    List<ProductDetailDTO>findByBrand(String brand);

    // select category,brand from product where productname=?1
    ProductBrandDTO findByProductName(String productName);

    // select category,brand from product where productname=?1
    IBrandDTO getByProductName(String productName);

//     select brand, productname from product where category=?1
    List<IProductDTO>findByCategory(String category);

//     select category,brand from product where productname=?1
    IProductInfo readByProductName(String productName);


}
