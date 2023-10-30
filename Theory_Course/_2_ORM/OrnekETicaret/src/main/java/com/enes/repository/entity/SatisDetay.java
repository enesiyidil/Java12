package com.enes.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblsatisdetay")
public class SatisDetay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long satisId;
    Long urunid;
    Integer adet;
    BigDecimal fiyat;
    BigDecimal toplamFiyat;

    @Embedded
    BaseEntity baseEntity;
}
