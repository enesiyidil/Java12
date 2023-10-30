package com.enes.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblsepet")
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;

    /*
     * K -> urun idleri
     * V -> adetler olacak
     */
    @ElementCollection
    Map<Long, Integer> urunids;

    @Embedded
    BaseEntity baseEntity;

}
