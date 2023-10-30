package com.enes.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class BaseEntity {
    /*
     * Tarih ve zaman damgası için genellikle Long veri türünde tutlması tavsiye edilir
     * Epoch time
     */
    Long olusturmaTarihi;
    Long guncellemeTarihi;
    Integer durum;
}
