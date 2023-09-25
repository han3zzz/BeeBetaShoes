package com.spring.beebeta.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/*
    @MappedSuperclass cho phép một thực thể kế thừa các thuộc tính từ một class lớn.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class Base implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "CreateDate")
    private Timestamp CreateDate;
    @Column(name = "UpdateDate")
    private Timestamp UpdateDate;
    @Column(name = "CreateBy")
    private String CreateBy;
    @Column(name = "UpdateBy")
    private String UpdateBy;
    @Column(name = "Status")
    private Integer Status;
}
