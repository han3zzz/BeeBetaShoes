package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rating")
public class Rating implements Serializable {
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
    @Column(name = "Note")
    private String Note;
    @Column(name = "Score")
    private Integer Score;
    @OneToMany(mappedBy = "rating")
    private Set<RatingImage> ratings = new HashSet<RatingImage>();
}
