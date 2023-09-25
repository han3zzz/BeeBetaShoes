package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Material;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Integer> {
}
