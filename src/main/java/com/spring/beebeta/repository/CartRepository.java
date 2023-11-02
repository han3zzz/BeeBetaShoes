package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "Select e from Cart  e where e.Id = :id")
    public Cart getByIdCart(@Param("id") Integer id);
}
