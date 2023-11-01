package com.enes;

import com.enes.criteriaornekler.CriteriaOrnekleri;

public class Main {
    public static void main(String[] args) {

        CriteriaOrnekleri criteriaOrnekleri = new CriteriaOrnekleri();
        criteriaOrnekleri.findAllByAd("%e%").forEach(System.out::println);


//        System.out.println("fields");
//        Class<Urun> myClass = Urun.class;
//
//        Field[] fields = myClass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println("Field Name: " + field.getName());
//            System.out.println("Field Type: " + field.getType().getName());
//            System.out.println("---------------------");
//        }
//        Urun urunLaptop = Urun.builder()
//                .ad("Laptop")
//                .fiyat(BigDecimal.valueOf(50000))
//                .stok(5)
//                .build();
//
//        new UrunRepository().findByEntity2(urunLaptop).forEach(System.out::println);
//        new UrunRepository().findByColumnNameAndValue("fiyat", BigDecimal.valueOf(50000)).forEach(System.out::println);
//
//
//
//        new UrunRepository().findByCondition((criteriaBuilder, root) -> {
//            Predicate p1 = criteriaBuilder.like(root.get("ad"), "Laptop");
//            Predicate p2 = criteriaBuilder.greaterThan(root.get("fiyat"), BigDecimal.valueOf(5));
//            return criteriaBuilder.or(p1, p2);
//        }).forEach(System.out::println);






//        BaseEntity baseEntity = BaseEntity.builder()
//                .durum(1)
//                .olusturmaTarihi(System.currentTimeMillis())
//                .guncellemeTarihi(System.currentTimeMillis())
//                .build();
//
//        Urun urunLaptop = Urun.builder()
//                .ad("Laptop")
//                .fiyat(BigDecimal.valueOf(50000))
//                .stok(5)
//                .baseEntity(baseEntity)
//                .build();
//
//        new UrunRepository().save(urunLaptop);

//        CriteriaOrnekleri criteriaOrnekleri = new CriteriaOrnekleri();
//        criteriaOrnekleri.findAll().forEach(System.out::println);
//        criteriaOrnekleri.selectOneColumn().forEach(System.out::println);
//        System.out.println(criteriaOrnekleri.selectOneColumnById(2L));
//        System.out.println(criteriaOrnekleri.findUrunById(2L));
//        criteriaOrnekleri.selectManyColumn().forEach(objects -> {
//            System.out.println("id: " + objects[0] + " Ad: " + objects[1] + " fiyat: "
//                    + (((BigDecimal)objects[2]).multiply(BigDecimal.valueOf(1.18)))
//            );
//        });
//        criteriaOrnekleri.findAllByNameAndPriceGt("%Ş%", BigDecimal.valueOf(15)).forEach(System.out::println);

        /*
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

         */
    }
}