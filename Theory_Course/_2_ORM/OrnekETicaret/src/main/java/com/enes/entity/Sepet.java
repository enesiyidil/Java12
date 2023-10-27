package com.enes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tblsepet")
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int urunid;

    public Sepet(int urunid) {
        this.urunid = urunid;
    }

}
