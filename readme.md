# 📚 Simple Dictionary App

Oddiy lug‘at (dictionary) dasturi **Spring Boot + PostgreSQL + Thymeleaf** texnologiyalari asosida ishlab chiqilgan.  
Dastur orqali foydalanuvchi so‘zlarni qidirishi, qo‘shishi, tahrirlashi va o‘chirishi mumkin.

---

## 🚀 Texnologiyalar
- Java 17+
- Spring Boot (Spring Data JPA)
- PostgreSQL
- Thymeleaf
- HTML/CSS

---

## ⚙️ Xususiyatlar
- 🔍 So‘zlarni qidirish
- ➕ Yangi so‘z qo‘shish
- ✏️ So‘zni tahrirlash
- 🗑️ So‘zni o‘chirish

---

## 📂 Loyihaning Struktura Diagrammasi

```plaintext
📦 com.example.dictionary
│
├── 📄 DictionaryApplication.java   ← Asosiy Spring Boot application
│
├── 📂 controller
│   ├── 📄 HomeController.java       ← Home page, search
│   └── 📄 DictionaryController.java ← CRUD amallari
│
├── 📂 dto
│   ├── 📄 DictionaryCreateDTO.java  ← Yangi so‘z qo‘shish uchun
│   └── 📄 DictionaryUpdateDTO.java  ← So‘zni tahrirlash uchun
│
├── 📂 entity
│   └── 📄 Dictionary.java           ← Entity (id, word, meaning, createdAt)
│
├── 📂 repository
│   └── 📄 DictionaryRepository.java ← JpaRepository interfeysi
│
└── 📂 service
    └── 📄 DictionaryService.java    ← Biznes logika
📂 resources
│
├── 📂 templates  (Thymeleaf sahifalar)
│   ├── 📄 home_page.html             ← So‘zlar ro‘yxati, search, CRUD tugmalar
│   ├── 📄 dictionary_create.html     ← Yangi so‘z qo‘shish formasi
│   └── 📄 dictionary_update.html     ← So‘zni tahrirlash formasi
│
├── 📂 db
│   └── 📂 postgresql
│       ├── 📄 schema-postgresql.sql  ← Jadval yaratish SQL
│       └── 📄 data-postgresql.sql    ← Test ma’lumotlar
│
├── 📄 application.properties         ← Umumiy konfiguratsiya
├── 📄 application-dev.properties     ← Dev uchun konfiguratsiya
├── 📄 application-prod.properties    ← Prod uchun konfiguratsiya
└── 📄 application-test.properties    ← Test uchun konfiguratsiya
