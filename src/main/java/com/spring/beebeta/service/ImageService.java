package com.spring.beebeta.service;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductImage;
import com.spring.beebeta.repository.ProductImageRepository;
import com.spring.beebeta.request.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ImageService {
    @Autowired
    ProductImageRepository repository;

    public ProductImage add(ImageRequest image){
        ProductImage productImage = new ProductImage();
        productImage.setUrl(image.getUrl());
        productImage.setMainImage(image.getMainImage());
        productImage.setProduct(Product.builder().Id(image.getIdProduct()).build());
        productImage.setCreateDate(new Date());
        productImage.setStatus(0);
        return repository.save(productImage);
    }
}
