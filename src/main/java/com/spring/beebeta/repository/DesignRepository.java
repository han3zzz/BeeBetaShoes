package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Design;
import com.spring.beebeta.entity.Size;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignRepository extends JpaRepository<Design,Integer> {
    @Query(value = "Select e from Design e where e.Status = 0")
    public List<Design> getAll();
}
