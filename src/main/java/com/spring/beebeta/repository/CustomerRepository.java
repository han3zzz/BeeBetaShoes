package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Color;
import com.spring.beebeta.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    @Query(value = "Select e from Customer e where e.Status = 0")
    public List<Customer> getAll();

    @Query(value = "select e from Customer e where e.Status = 0 and e.Fullname like :fullname" )
    public List<Customer> searchByFullName(@Param("fullname") String fullname);

    @Query(value = "select e from Customer e where e.Id = :id")
    public Customer getById(@Param("id") Integer Id);
}
