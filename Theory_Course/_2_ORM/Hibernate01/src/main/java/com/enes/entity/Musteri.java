package com.enes.entity;

import javax.persistence.*;
/*
    @GeneratedValue strategy'leri:
        1. GenerationType.IDENTITY  : 1'den başlar ve her yeni kayıt geldiğinde otomatik olarak 1 arttırır.
        2. GenerationType.SEQUENCE  :
            SEQUENCE oluşturma  :
                @SequenceGenerator(name = "seqMusteri", sequenceName = "tblmusteri_id_seq", initialValue = 10, allocationSize = 2)
            SEQUENCE atama      :
                @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMusteri")
        3. GenerationType.AUTO      : Veritabanı bazında tek sequence oluşturur. Onunla değer arttırımını sağlar.
        4. GenerationType.TABLE     : Sequenceler için tablo oluşturur.

    YAPILMASI GEREKENLER:
        * Boş constructor
        * id'siz constructor
        * Dolu constructor
        * GETTER ve SETTER
 */
@Entity
@Table(name = "tblmusteri")
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String ad;
    String soyad;
    String adres;

    public Musteri() {
    }

    public Musteri(String ad, String soyad, String adres) {
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public Musteri(int id, String ad, String soyad, String adres) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
