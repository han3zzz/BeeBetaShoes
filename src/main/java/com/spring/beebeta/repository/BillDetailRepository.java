package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Bill;
import com.spring.beebeta.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Integer> {

    @Query("select e from BillDetail e where e.bill.Code = :code")
    List<BillDetail> getAllByBill(@Param("code") String code);
    @Query("select e from BillDetail e where e.Id = :id")
    public BillDetail getById(@Param("id") Integer id);
    @Query(value = "Select b from BillDetail b\n" +
            "join Bill  c on c.Id = b.bill.Id \n" +
            "where b.productDetail.Id = :id and c.Status = 3")
    public List<BillDetail> getAllByIdProduct(@Param("id") Integer id);
}
