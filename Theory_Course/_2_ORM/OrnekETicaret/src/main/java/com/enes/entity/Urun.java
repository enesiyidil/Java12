package com.enes.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tblurun")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String ad;
    double fiyat;

    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

}
