package com.enes.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblurun")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String barkod;
    String marka;
    String model;
    BigDecimal fiyat;
    Integer stok;

    @Embedded
    BaseEntity baseEntity;

}
