package org.enes;

import org.enes.util.Menu;
/*
    1- personDb oluşturalım --> id, firstName, lastName, joinedDate
    2- Util paketinde JDBCHelper class oluşturalım getConnection() bu metod bize connection nesnesi dönecek
    3- Buradaki databasebilgileri farklı bir sınıftan çekelim --> JDBCConstant
    4- Database veri ekleme register işlemi, kullanıcıdan isim soyisim email alacağız database kaydedeceğiz
 */
public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.menu();

    }
}