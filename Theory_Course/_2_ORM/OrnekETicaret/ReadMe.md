# Hibernate ile Adım Adım Proje Oluşturmak

1. Veritabanı sunucusunda bir veritabanı oluştur. (Java12OrnekETicaret)
2. Package oluşturalım.
3. Resources package içine config dosyasını at.
4. hibernate.cfg.xml dosyasında gerekli değişiklikleri yap
5. build.gradle dosyasına dependencies ekle.
6. Gerekli entity'leri ekle. (Sepet, Urun)
7. Entityler için:
   1. Boş constructor
   2. Idsiz constructor
   3. Dolu constructor
   4. Getter & Setter
   5. toString
8. hibernate.cfg.xml dosyasında mapping işlemini yap.
9. utility package içine HibernateUtility.java dosyasını ekle


# Kullanma Adımları

1. Session oluştur:
   * `Session session = HibernateUtility.getSessionFactory().openSession();`
   * `session.close();`
2. Treansaction oluştur ve başlat:
   * `Transaction transaction = session.beginTransaction();`
   * `transaction.commit();`
3. CRUD işlemlerini yap

# Türkçe karakter sorunu için
1. build.gradle içine:
   * `tasks.withType(JavaCompile).configureEach{options.encoding='UTF-8'}`

