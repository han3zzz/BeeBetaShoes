package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Category;
import com.spring.beebeta.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
