package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {
}
