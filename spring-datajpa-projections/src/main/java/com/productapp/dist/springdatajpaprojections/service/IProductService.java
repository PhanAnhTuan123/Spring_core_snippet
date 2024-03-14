package com.productapp.dist.springdatajpaprojections.service;

import com.productapp.dist.springdatajpaprojections.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

    void addProduct(Product product);
//     Projection using DTO as class
    List<ProductDetailDTO>findByBrand(String brand);
    ProductBrandDTO findByProductName(String productName);

    IBrandDTO getByProductName(String productName);
    List<IProductDTO>findByCategory(String category);
    IProductInfo readByProductName(String productName);
}
