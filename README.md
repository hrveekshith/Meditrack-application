# 🏥 MediTrack Application

**MediTrack** is a modular, full-stack medical management system built using **Spring Boot**.  
It provides complete functionality for managing **patients**, **doctors**, **appointments**, **prescriptions**, and **medicines** — with a clean, feature-based architecture for scalability and maintainability.

---

## 🚀 Project Status
🔧 *Currently under active development.*

---

## 🧩 Overview

MediTrack simplifies medical workflow management by integrating:

- 👨‍⚕️ **Doctors** → manage appointments, prescribe medicines  
- 🧑‍🤝‍🧑 **Patients** → book and track appointments, view prescriptions  
- 💊 **Medicines** → linked to prescriptions and appointments  
- 🗓️ **Appointments** → connect patients and doctors efficiently  

The project follows a **feature-modular architecture**, where every entity (Doctor, Patient, Appointment, etc.) is self-contained with its own:
- Model  
- Repository  
- Service  
- Controller  
- DTO  
- Mapper  

---

## 🧱 Architecture Overview

MediTrack/
├── src/
│ ├── main/java/com/mediTrack/
│ │ ├── doctor/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ └── mapper/
│ │ ├── patient/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ └── mapper/
│ │ ├── appointment/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ └── mapper/
│ │ ├── prescription/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ └── mapper/
│ │ ├── medicine/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ └── mapper/
│ │ └── MeditrackApplication.java
│ └── resources/
│ ├── application.properties
│ ├── data.sql
│ └── schema.sql
├── pom.xml
└── README.md

yaml
Copy code

✅ **Why modular?**
- Easy to scale: add new entities without touching existing ones.  
- Maintains clean separation of concern per feature.  
- Ideal for large codebases and microservice migration later.

---

## 🛠️ Tech Stack

| Layer | Technology |
|--------|-------------|
| **Language** | Java 17+ |
| **Framework** | Spring Boot 3.x |
| **ORM / Database** | Spring Data JPA (Hibernate) + MySQL |
| **Build Tool** | Maven |
| **Testing** | JUnit, Postman (for APIs) |
| **Planned** | Spring Security + JWT, Swagger, Docker |

---

## 💡 Key Features

### ✅ Implemented
- Entity relationships between Doctor, Patient, Appointment, Prescription, and Medicine  
- CRUD operations for each module  
- Feature-modular package structure  
- Bidirectional JPA mappings using `@OneToMany`, `@ManyToOne`, `@JoinColumn`  
- Service + Repository + DTO layering  

### 🔄 Upcoming
- Authentication & Role-based access control  
- API documentation via Swagger  
- Email/Notification service  
- React/Thymeleaf frontend integration  
- Docker support for deployment  

---

## 🧠 Database Relationships (Simplified)

- **Doctor** ⟷ **Appointment** → One-to-Many  
- **Patient** ⟷ **Appointment** → One-to-Many  
- **Appointment** ⟷ **Prescription** → One-to-One  
- **Prescription** ⟷ **Medicine** → One-to-Many  

---

## ⚙️ How to Run Locally

### 1️⃣ Clone the repo
```bash
git clone https://github.com/hrveekshith/Meditrack-application.git
cd Meditrack-application
2️⃣ Configure the database
Edit src/main/resources/application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/meditrack
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3️⃣ Build & run
bash
Copy code
mvn clean install
mvn spring-boot:run
4️⃣ Access the APIs
Base URL: http://localhost:8080/api/

Example: http://localhost:8080/api/patients
