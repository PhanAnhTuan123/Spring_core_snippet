package com.productapp.dist.springdatajpaprojections.model;

import org.springframework.beans.factory.annotation.Value;

public interface IProductInfo {
    @Value("#{target.brand +''+target.category}")
    String getDetails();
}
