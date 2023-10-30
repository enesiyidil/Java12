package com.enes.repository.entity;

/*
 * Hibernate içinde birçok configurasyon @ anatasyonlarla yapıldığı için bunlar neler olduğu ve
 * ne işe yaradıklarını bilmek çok önemlidir.
 *
 * @Entity          : Bu sınıfın varlık sınıfı olduğunu belirtir. ORM aracı buradan bir tablo oluşturur.
 * @Table           : Üzerine eklendiği sınıfın DB'deki özelliklerini düzenlemek için kullanılır. Her tablo için bir isim
 *                    verilmesi önerilir. Eqer name verilmez ise tablo adı sınıfın adı olarak belirlenir.
 * @Id              : Üzerinde bulunduğu alanı tabloada PK yapar.
 * @GeneratedValue  : Sequence oluşturmak için
 *
 */

import com.enes.enums.ECinsiyet;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "tblmusteri")
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "musteriAd",     // tablodaki kolon adı
            length = 30,            // kolonun boyutu
            nullable = false,       // null değer alamaz
            unique = false,         // unik değer olmaz
            insertable = true,
            updatable = false
    )
    String ad;
    String soyad;

    /*
     * Bir kullanıcının birden çok telefon numarasını tutmak için list türünü kullanabiliriz.
     * Ancak List gibi Collection türlerini @Entity ile işaretlenmiş sınıfta tutmak istersek hata alırız.
     * Bu türün mutlaka @ElementCollection ile işaretlenmesi gerekir
     * Bu anotasyon ile işaretlenen alan için ayrı bir tablo oluşturur
     */
    @ElementCollection
    List<String> telefon;

    /*
     * Zaman tanımlamaları için @Temporal kullanılır.
     *    TemporalType.DATE           -> sadece tarih bilgisi tutar
     *    TemporalType.TIME           -> sadece zaman bilgisi tutar
     *    TemporalType.TIMESTAMP      -> zaman tarih bilgisi tutar
     */
    @Temporal(TemporalType.DATE)
    Date dogumTarihi;

    @Temporal(TemporalType.DATE)
    Date isGirisTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    Date kayitTarihi;

    /*
     * VTdeki kolon olarak tutlmasını engeller
     */
    @Transient
    String adSoyad;

    /*
     * Enum bilgiler 2 alandan oluşur.
     * Enum değeri int, görünen değeri String
     * Hangi değerin VT'ye kaydedileceği burada belirlenebilir
     *      -> EnumType.ORDINAL
     *      -> EnumType.STRING
     */
    @Enumerated(EnumType.STRING)
    ECinsiyet cinsiyet;

    @Embedded
    BaseEntity baseEntity;

    @Embedded
    Iletisim iletisim;
}
