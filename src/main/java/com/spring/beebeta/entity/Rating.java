package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Rating")
public class Rating extends Base{
    @Column(name = "Note")
    private String Note;
    @Column(name = "Score")
    private Integer Score;
    @OneToMany(mappedBy = "rating")
    private Set<RatingImage> ratings = new HashSet<RatingImage>();
}
