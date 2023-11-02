# Personel - Department Arası İlişki (One-to-Many)
One-to-Many bidirectional ilişkilerde
* Üst Varlık: Çoğul olandır. (Personel)
  * `@ManyToOne(cascade = CascadeType.ALL)`
  * `@JoinColumn(name = "d_id")` olarak işaretlenir.
* Alt Varlık: Tekil olandır. (Department)
  * `@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)` olarak işaretlenir.

1 departmanda birden çok personel olabilir.
1 personel bir departmanda çalışabilir.

Departman - Personel ilişkisi one-tomany bu ilişki türünde many olan tarafa (**Personel**) yeni bir sütun ekleriz.
Ve bu sütunda one tarafındaki (**Departman**) PK'yi (**id**) FK (**departman_id**) olarak tutarız.

# Personel - Araba Arası ilişki (One-toOne)
1 personel 1 araba sahibi olabilir. 1 araba 1 personele ait olabilir.

Personel - Car ilişkisi one-to-one Personel tablosunda car_id FK olarak tutacak yeni bir sütun açılır.