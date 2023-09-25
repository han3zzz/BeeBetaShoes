package com.spring.beebeta.repository;

import com.spring.beebeta.entity.ProductDetail_Size_Color;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetail_Size_ColorRepository extends JpaRepository<ProductDetail_Size_Color,Integer> {
}
