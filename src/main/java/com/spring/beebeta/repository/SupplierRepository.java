package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    @Query(value = "select  e from Supplier e where e.productDetail.Id = :id")
    public List<Supplier> getAllById(@Param("id") Integer id);
}
