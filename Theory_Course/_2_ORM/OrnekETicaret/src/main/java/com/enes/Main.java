package com.enes;

import com.enes.enums.ECinsiyet;
import com.enes.repository.entity.*;
import com.enes.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        BaseEntity baseEntity = BaseEntity.builder()
                .durum(1)
                .olusturmaTarihi(System.currentTimeMillis())
                .guncellemeTarihi(System.currentTimeMillis())
                .build();

        Urun urunSeker = Urun.builder()
                .ad("Şeker")
                .fiyat(BigDecimal.valueOf(20))
                .stok(100)
                .baseEntity(baseEntity)
                .build();

        Urun urunUn = Urun.builder()
                .ad("Un")
                .fiyat(BigDecimal.valueOf(40))
                .stok(100)
                .baseEntity(baseEntity)
                .build();

        session.save(urunSeker);
        session.save(urunUn);

        Satis satis = Satis.builder()
                .musteriid(1L)
                .tarih(System.currentTimeMillis())
                .baseEntity(baseEntity)
                .toplamTutar(BigDecimal.valueOf(500))
                .build();

        session.save(satis);

        SatisDetay satisDetaySeker = SatisDetay.builder()
                .urunid(1L)
                .fiyat(BigDecimal.valueOf(20))
                .adet(5)
                .toplamFiyat(BigDecimal.valueOf(100))
                .baseEntity(baseEntity)
                .satisId(1L)
                .build();

        SatisDetay satisDetayUn = SatisDetay.builder()
                .urunid(2L)
                .fiyat(BigDecimal.valueOf(40))
                .adet(10)
                .toplamFiyat(BigDecimal.valueOf(400))
                .baseEntity(baseEntity)
                .satisId(1L)
                .build();

        session.save(satisDetaySeker);
        session.save(satisDetayUn);

//        List<String> teller = new ArrayList<>();
//        teller.add("tel1");
//        teller.add("tel2");
//        teller.add("tel3");
//        teller.add("tel4");
//        Musteri m1 = Musteri.builder()
//                .ad("Fatih")
//                .telefon(teller)
//                .build();
//        session.save(m1);
//
//        List<String> teller2 = new ArrayList<>();
//        teller2.add("tel10");
//        teller2.add("tel20");
//        teller2.add("tel30");
//        teller2.add("tel40");
//
//        Iletisim iletisim = Iletisim.builder()
//                .adres("İstanbul")
//                .ceptelefonu("12345")
//                .email("engin@gmail.com")
//                .build();
//
//        Musteri m2 = new Musteri();
//        m2.setAd("Engin");
//        m2.setSoyad("Kara");
//        m2.setAdSoyad(m2.getAd() + m2.getSoyad());
//        m2.setTelefon(teller2);
//        m2.setDogumTarihi(new Date());
//        m2.setCinsiyet(ECinsiyet.ERKEK);
//        m2.setBaseEntity(baseEntity);
//        m2.setIletisim(iletisim);
//        session.save(m2);



        transaction.commit();
        session.close();
    }
}