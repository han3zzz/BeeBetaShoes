package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
    @Query(value = "Select e from ProductDetail e where e.Id = :id")
    public ProductDetail getById(@Param("id") Integer id);
    @Query(value = "Select e from ProductDetail e where e.Status = 0")
    public List<ProductDetail> getAll();
}
