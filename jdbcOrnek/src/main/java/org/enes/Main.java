package org.enes;
/*
Veritabanı Driver:
Bir programlama dili ile Veritabanı arasında iletişim kurmak için kullanılan bileşendir.
Yapılabilecekler:
    VT Sunucusuna bağlanmak
    VT ile iletişim kurma
    Sorgular gönderme
    Sonuçları alma bu tür temel işlemleri yapmakta yardımcı olur
Driverleri VT üreticisi üretir
PostgreSQL JDBC DRIVER

Dependencies: Dışarıdan projeye dahil edilen kütüphanelere olan bağımlılık
    ANT - MAVEN - GRADLE

// JDBC kullanımında ilk yapılacak işlem 2 sistem arasında iletişimi sağlayacak DRIVER'i devreye almaktır
// Driver.class.forName("org.postgresql.Driver");
// Driverla sunucuya bağlanabilmek için gerekli parametreler:
// 1. VT server'ının IP adresi
// 2. Port numarası
// 3. İşlem yapılacak DB adı
// 4. Yetkilendirme için username
// 5. Yetkilendirme için password
// jdbc:postgresql://host:port/database
// host: VT tutan yapı. Eğer uzak sunucudaysa ip adresi, lokal ise localhost veya 127.0.0.1 yazılır
// DriverManager aracılığı ile bir Connection nesnesi oluşturulur.
// Connection referansı oluşturabilmek için url, username ve password bilgilerini getConnection metoduna verdik
// Bu yazılan sql Driver tarafından anlaşılmaz
// Driver'ın anlayabileceği yapıya getirmek için prepareStatement kullanılır
*/
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            adresEkle(70, "İstanbul", "Bakırköy", "Yeşilköy", "Çınar Sk. No: 3");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adresEkle(int customerId, String il, String ilce, String mahalle, String adres) throws SQLException {
        String connectionAdress = "jdbc:postgresql://localhost:5432/Java12SatisDB";
        String username = "postgres";
        String password = "1234";
        Connection connection = DriverManager.getConnection(connectionAdress, username, password);

        String adresEkleSql = "INSERT INTO public.tbladres(musteriid, il, ilce, mahalle, adres) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(adresEkleSql);
        preparedStatement.setInt(1, customerId);
        preparedStatement.setString(2, il);
        preparedStatement.setString(3, ilce);
        preparedStatement.setString(4, mahalle);
        preparedStatement.setString(5, adres);

        preparedStatement.executeUpdate();
        connection.close();
    }
}