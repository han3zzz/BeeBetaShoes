package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Bill;
import com.spring.beebeta.entity.BillDetail;
import com.spring.beebeta.response.BillDaBanResponse;
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
    @Query(value = "Select bd.IdColor,bd.IdSize ,SUM(bd.Quantity) as 'Quantity', SUM(bd.UnitPrice * bd.Quantity) as 'Price' from BillDetail bd\n" +
            "join Bill b on b.Id = bd.IdOrder\n" +
            "where bd.IdProductDetail = :id and b.Status = 3\n" +
            "group by bd.IdColor,bd.IdSize ", nativeQuery = true)
    public List<BillDaBanResponse> getAllByIdProduct(@Param("id") Integer id);
}
