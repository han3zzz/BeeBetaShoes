package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Category;
import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "Select e from Category e where e.Status = 0")
    public List<Category> getAll();
}
