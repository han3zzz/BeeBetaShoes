package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
}
