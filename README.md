# Finance Data Processing and Access Control Dashboard

## Project Overview
This project is a Spring Boot backend application for managing financial records with role-based access control.  
It provides REST APIs for users, financial records, and dashboard analytics.

---

## Features
- User Management (Admin / User roles)
- Financial Records CRUD operations
- Role-based access control
- Dashboard summary APIs
- Filter records by date, category, type
- PostgreSQL database integration
- Swagger API documentation
- Input validation and exception handling

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- Swagger (OpenAPI)

---

## 📂 Project Structure
- controller/
- service/
- repository/
- entity/
- config/
- exception/

---

## ▶️ How to Run
1. Clone repository
     git clone https://github.com/ashikamanivel05/finance-dashboard.git
2. Navigate to project
     cd finance-dashboard
3. Run application
     mvn spring-boot:run



---

## 🗄 Database Configuration
Update `application.properties`:
   spring.datasource.url=jdbc:postgresql://localhost:5432/finance_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password


---

## 📊 Swagger API Documentation
After running application:
    http://localhost:8080/swagger-ui/index.html



---

## 🔐 Roles
- ADMIN → Manage users and records
- USER → Manage own financial records

---

## 👩‍💻 Author
Ashika M
