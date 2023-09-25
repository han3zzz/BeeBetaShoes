package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Design;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignRepository extends JpaRepository<Design,Integer> {
}
