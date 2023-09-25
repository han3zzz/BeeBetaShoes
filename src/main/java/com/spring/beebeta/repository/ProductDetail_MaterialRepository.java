package com.spring.beebeta.repository;

import com.spring.beebeta.entity.ProductDetail_Material;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetail_MaterialRepository extends JpaRepository<ProductDetail_Material,Integer> {
}
