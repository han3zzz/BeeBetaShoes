package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
