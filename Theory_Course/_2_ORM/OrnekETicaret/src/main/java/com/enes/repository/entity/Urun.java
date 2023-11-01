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
@NamedQuery(name = "Urun.findAll", query = "SELECT u FROM Urun u")
@NamedQuery(name = "Urun.findByAd", query = "SELECT u FROM Urun u WHERE u.ad LIKE :urunad")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String ad;
    public String barkod;
    public String marka;
    public String model;
    public BigDecimal fiyat;
    public Integer stok;

    @Embedded
    public BaseEntity baseEntity;

}
