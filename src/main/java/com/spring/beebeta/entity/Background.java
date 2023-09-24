package com.spring.beebeta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Background")
public class Background extends Base{
    @Column(name = "Type")
    private String Type;
    @Column(name = "Url")
    private String Url;
    @Column(name = "Content")
    private String Content;
}
