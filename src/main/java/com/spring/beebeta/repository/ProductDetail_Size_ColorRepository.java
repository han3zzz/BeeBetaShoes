package com.spring.beebeta.repository;

import com.spring.beebeta.entity.ProductDetail_Material;
import com.spring.beebeta.entity.ProductDetail_Size_Color;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetail_Size_ColorRepository extends JpaRepository<ProductDetail_Size_Color,Integer> {
    @Query(value = "Select e from ProductDetail_Size_Color  e where  e.productDetail.Id =:id")
    List<ProductDetail_Size_Color> getAllById(@Param("id") Integer id);
}
