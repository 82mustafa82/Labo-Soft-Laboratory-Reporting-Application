# Labo Soft Laboratuvar Raporlama Uygulaması

Labo Soft, laboratuvar çalışanlarının rapor yazmasına olanak sağlayan bir uygulamadır. İlgili hastanın bilgilerinin girilmesi ve sonradan incelenmesi esas alınmıştır. Bu bilgi sisteminde, kullanıcılar yöneticiler ve laborantlar olarak ikiye ayrılır. Yöneticilerin tam yetkisi varken, laborantların yani sistemin sıradan kullanıcılarının rapor oluşturma ve düzeltme yetkileri vardır. Özetle, uygulama bu şekildedir. 

---
___

## Kurulum 

> Öncelikle, veritabanı yönetim sisteminden "*dump*" dosyası aracığıyla veritabanı kurulur. 

> İlgili dosya içerisinde terminal aracılığıyla shell java komutu ile jar dosyası oluşturulup çalıştırılır. Ardından internet tarayıcıdan "localhost:8080" adresi girilerek uygulamaya girilir. 

Projeyi çalıştırmak için ( "*.jpathylab*" dosyasının masaüstünde olduğu varsayılarak) : 

```bash
cd Desktop/jpathylab
mvn package
cd target
java -jar jpathylab-0.0.1-SNAPSHOT.jar
```

[Github](*link*) linkinden uygulama dosyası indirilebilir. 

Uygulamada kullanılan teknolojiler : 
* JPA
* Thymeleaf
* Spring Web
    * Spring Boot Test 
    * Spring Boot Security 
* Dev Tools 
* MySql
* Bootstrap
* Webjars 
* AssertJ

Uygulama geliştirmek için kullanılan yazılımlar : 
* Linux Terminal 
(İşletim sistemi olmasından dolayı)
* Visual Studio Code 
(Ön yüz tasarımı için)
* Intellij IDEA 
(Kolay kullanımından dolayı)
* MySql Workbench 
(Basit bir uygulama oluşundan dolayı)

Uygulama için kullanılan sınıflar : 

| |Laborant|Report|User|CustomUserDetails|
|-|--------|------|----|------------------|
|Controller|+|+|+|-|
|Exception|+|+|+|-|
|Model|+|+|+|+|
|Repository|+|+|+|-|
|Service|+|+|+|+|

Proje Aşamaları : 

* ## [x] Ön Yüz Tasarımı 

Proje ön yüz tasarımı için Bootstrap kullanılarak bir template inşa edilmiştir. Ancak, daha sonra oluşturulan bu template'in, uygulamanın minimal yapısına uymadığı düşünülerek, template'den vazgeçilmiş ve daha sade bir tasarım hazırlanmıştır. 

* ## [x] Dependency Seçimi 

Dependency seçimi için "*mvnrepository*" sitesinden yararlanılmıştır. 

* ## [x] Veritabanı Bağlantıları 

Veritabanı bağlantıları için JPA ve Crud kullanılmıştır. 

* ## [x] Birim Testleri (Örnek)

    * testListAll (SELECT)

    ```java
        Iterable<Laborant> laborants = repo.findAll();
        Assertions.assertThat(laborants).hasSizeGreaterThan(0);
        for (Laborant laborant : laborants){
            System.out.println(laborant);
        }
    ```

    * testCreateLaborants (INSERT)

    ```java
        Laborant laborant1 = new Laborant("Furkan", "Erçelebi", "3333333");
        Laborant laborant2 = new Laborant("Ömer", 
        entityManager.persist(laborant1);
    ```

    * testUpdate (UPDATE)

    ```java
        Integer lid = 2;
        Optional<Laborant> optionalLaborant = repo.findById(lid);
        Laborant laborant = optionalLaborant.get();
        laborant.setLaborantLastName("Tanrikulu");
        repo.save(laborant);
        Laborant updatedLaborant = repo.findById(lid).get();
        Assertions.assertThat(updatedLaborant.getLaborantLastName()).isEqualTo("Tanrikulu");
    ```

    * testRemoveLaborantFromExistingReport (DELETE)

    ```java
        Report report = repo.findById(4).get();
        Laborant laborant = new Laborant(10);
        report.removeLaborant(laborant);
    ```

* ## [x] Ön Yüz ve Arka Yüz Birleştirme 
  Burada Thymeleaf fonksiyonları kullanılmıştır :   
    * xmlns:th
    * th:href
    * th:action
    * th:field

* ## [x] Login Ekranı Tasarımı 
* ## [x] Yetkilendirme Mekanizması Ayarlama 
 Admin : 

    * Laborant listeleme, ekleme, düzenleme, silme 
    * Rapor listeleme, ekleme, düzenleme, silme 
    * Kullanıcı listeleme, ekleme, düzenleme, silme 

 Laborant : 

    * Rapor listeleme, ekleme, düzenleme 
