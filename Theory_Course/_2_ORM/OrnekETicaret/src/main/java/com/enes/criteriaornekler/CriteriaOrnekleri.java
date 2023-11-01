package com.enes.criteriaornekler;

import com.enes.repository.entity.Musteri;
import com.enes.repository.entity.Urun;
import com.enes.repository.views.VwUrun;
import com.enes.utility.HibernateUtility;
import org.hibernate.Session;

import javax.persistence.Table;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

public class CriteriaOrnekleri {

    Session session;
    CriteriaBuilder criteriaBuilder;

    public CriteriaOrnekleri() {
        session = HibernateUtility.getSessionFactory().openSession();
        criteriaBuilder = session.getCriteriaBuilder();
    }

    /**
     * Sorgu 1: SELECT * FROM tblmusteri --> Geriye ne döner => müşterilerden oluşan bir liste dönecek.
     */
    public List<Musteri> findAll() {
        /*
         * Kriter tanımlanırken kullanılacak sınıfın adını vererek işleme başlarız.
         * Bu sınıf .class olarak verilmelidir.
         * Reflection PI sayesinde arka planda o class içindeki tüm fieldlar belirlenir.
         */
        CriteriaQuery<Musteri> criteriaQuery = criteriaBuilder.createQuery(Musteri.class);

        /*
         * Sorgunun atılacağı tabloyu belirleyelim
         */
        Root<Musteri> root = criteriaQuery.from(Musteri.class);

        /*
         * Sorguda hangi alanlar seçilecek onu tanımlamalıyız.
         * Select içindeki root ifadesi * anlamına gelmektedir.
         */
        criteriaQuery.select(root);

        /*
         * Sorgunuz hazır olduktan sonra bunu çalıştırmalısınız.
         */
        return session.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Sorgu 2: SELECT ad FROM tblmusteri --> Geriye ne döner => Stringlerden oluşan bir liste döner
     */
    public List<String> selectOneColumn() {
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        /*
         * Sorguda SELECT ile seçilen alanların olduğu kısım.
         * Şu an ad sütunu seçili hale getirildi.
         * Root içerisinde tüm kolonlar vardır ve get ile onların içinden seçim yapılabilir.
         */
        criteriaQuery.select(root.get("ad"));
        return session.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Sorgu 3: SELECT ad FROM tblurun WHERE id=idParametre --> Geriye ne döner => String döner
     */
    public String selectOneColumnById(Long idParametre) {
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        /*
         * Predicate bir koşul oluşturma işlemidir.
         * WHERE sorgusu bir veya birden çok predicate bekler.
         * Koşulunuzu predicate olarak oluşturup WHERE sorgusuna aktarmalısınız.
         * '=' yerine --> equal metodu
         * '>' terine --> greaterThan gibi metodlar kullanılır.
         */
        Predicate p1 = criteriaBuilder.equal(root.get("id"), idParametre);
        /*
         * 2 işlem ard arda gelebilir.
         */
        criteriaQuery.select(root.get("ad")).where(p1);
        return session.createQuery(criteriaQuery).getSingleResult();
    }

    /**
     * Sorgu 4: SELECT * FROM tblurun WHERE id=idParametre --> Geriye ne döner => Urun döner
     */
    public Urun findUrunById(Long idParametre) {
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Predicate p1 = criteriaBuilder.equal(root.get("id"), idParametre);
        criteriaQuery.select(root).where(p1);
        return session.createQuery(criteriaQuery).getSingleResult();
    }

    /**
     * Sorgu 5: SELECT id, ad, fiyat FROM tblurun  --> Geriye ne döner => List Object[] veya tuple döner
     */
    public List<Object[]> selectManyColumn() {
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        /*
         * javax.persistence.criteria.Path
         */
        Path<Long> pathId = root.get("id");
        Path<String> pathAd = root.get("ad");
        Path<BigDecimal> pathFiyat = root.get("fiyat");
//        criteriaQuery.select(criteriaBuilder.array(pathId, pathAd, pathFiyat));
        // Bir üst satırdaki metodun alternatifi multiselect
        criteriaQuery.multiselect(pathId, pathAd, pathFiyat);
        return session.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Sorgu 6: SELECT * FROM WHERE ad like '%?%' and fiyat > ?  --> Geriye ne döner => Stringlerden oluşan bir liste döner
     */
    public List<Urun> findAllByNameAndPriceGt(String urunAd, BigDecimal fiyat) {
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Predicate p1 = criteriaBuilder.like(root.get("ad"), urunAd);
        Predicate p2 = criteriaBuilder.greaterThan(root.get("fiyat"), fiyat);
        Predicate sonKosul = criteriaBuilder.and(p1, p2);
        criteriaQuery.select(root).where(sonKosul);
        return session.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Native Guery SQL kodları ile JPA(Hibernate) üzerinden sorgulama yapabilirsiniz.
     */
    public List<Urun> findAllNativeQuery(){
        return session.createNativeQuery("SELECT * FROM " + Urun.class.getAnnotation(Table.class).name(), Urun.class).getResultList();
    }

    public List<VwUrun> findAllNativeQuery2(){
        return session.createNativeQuery("SELECT * FROM " + Urun.class.getAnnotation(Table.class).name(), VwUrun.class).getResultList();
    }

    /**
     * Named Query
     * Kullanılacak dil: JPQL, HQL
     * Entity üzerine yazılır
     * SQL  --> SELECT * FROM tblmusteri
     * JPQL --> SELECT m FROM Musteri m
     * HQL  --> FROM Musteri
     */
    public List<Urun> findAllNamedQuery(){
        return session.createNamedQuery("Urun.findAll", Urun.class).getResultList();
    }

    public List<Urun> findAllByAd(String urunAd){
        return session.createNamedQuery("Urun.findByAd", Urun.class).setParameter("urunad", urunAd).getResultList();
    }
}
