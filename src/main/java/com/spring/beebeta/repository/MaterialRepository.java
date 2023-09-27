package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Material;
import com.spring.beebeta.entity.Size;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Integer> {
    @Query(value = "Select e from Material e where e.Status = 0")
    public List<Material> getAll();
}
