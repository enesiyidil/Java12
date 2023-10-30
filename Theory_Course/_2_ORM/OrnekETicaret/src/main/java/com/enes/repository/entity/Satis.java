package com.enes.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblsatis")
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long tarih;
    /*
     * Ödeme sırasında oluşan tutar
     */
    BigDecimal toplamTutar;

    @Embedded
    BaseEntity baseEntity;

}
