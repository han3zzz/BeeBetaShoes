package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Material;
import com.spring.beebeta.entity.Size;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Integer> {
    @Query(value = "Select e from Material e where e.Status = 0")
    public List<Material> getAll();
    @Query(value = "Select e from Material e where e.Status = 0 and e.Name like :name")
    public List<Material> searchByName(@Param("name") String name);
    @Query(value = "select e from Material e where e.Id = :id")
    public Material getById(@Param("id") Integer Id);
}
