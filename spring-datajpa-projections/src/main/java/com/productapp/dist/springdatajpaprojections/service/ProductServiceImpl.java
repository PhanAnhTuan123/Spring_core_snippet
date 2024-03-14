package com.productapp.dist.springdatajpaprojections.service;

import com.productapp.dist.springdatajpaprojections.model.*;
import com.productapp.dist.springdatajpaprojections.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  IProductService{

    IProductRepository iProductRepository;

    @Autowired
    public void setiProductRepository(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }


    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<ProductDetailDTO> findByBrand(String brand) {
        return iProductRepository.findByBrand(brand);
    }

    @Override
    public ProductBrandDTO findByProductName(String productName) {
        return iProductRepository.findByProductName(productName);
    }

    @Override
    public IBrandDTO getByProductName(String productName) {
        return iProductRepository.getByProductName(productName);
    }

    @Override
    public List<IProductDTO> findByCategory(String category) {
        return iProductRepository.findByCategory(category);
    }

    @Override
    public IProductInfo readByProductName(String productName) {
        return iProductRepository.readByProductName(productName);
    }
}
