package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Sole;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoleRepository extends JpaRepository<Sole,Integer> {
}
