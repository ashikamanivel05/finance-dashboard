# Finance Data Processing and Access Control Dashboard

## Project Overview
This is a robust Spring Boot backend designed for a financial dashboard. It features Role-Based Access Control (RBAC), automated financial summaries, and a secure API structure.

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
- Framework: Spring Boot 3.x
- Security: Spring Security (Method-level security with @PreAuthorize)
- Database: H2 (In-Memory) / Spring Data JPA
- Documentation: SpringDoc OpenAPI (Swagger)
- Tooling: Lombok, Jakarta Validation

---

## Architecture Overview
- The project follows a Layered Architecture to ensure separation of concerns:
- Controller Layer: Handles HTTP requests and enforces security roles.
- Service Layer: Contains business logic and data aggregation (Streams/Logic).
- Repository Layer: Manages database interactions using Spring Data JPA.
- Security Layer: Implements a custom UserDetailsService to authenticate users from the database.

---

## ▶️ How to Run
1. Prerequisites
- Java 17 or higher
- Maven 3.6+

2. Run the Application
- mvn spring-boot:run
  
3. Access the API Documentation
- Once the app is running, open your browser and go to:
  http://localhost:8080/swagger-ui/index.html

---

## Authentication & Roles
The system is pre-seeded with the following credentials for testing:
Role          Email                    Password        Permissions
Admin         admin@finance.comadmin   123             Full Access (CRUD Users & Records)
Analyst       analyst@finance.com      analyst123      View Records + Access Dashboard Insights
Viewer        viewer@finance.com       viewer123       Read-only access to records

 

## How to Authenticate in Swagger:
- Click the green "Authorize" button at the top right
- Enter the Email as the username and the Password.
- Click Authorize. All subsequent requests will now be authenticated with that role.

## 🗄 Database Configuration
Update `application.properties`:
   spring.datasource.url=jdbc:postgresql://localhost:5432/finance_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password


---

## API Endpoints Reference
👤 User Management (/users)

| Method | Endpoint | Access Role | Description |
|--------|----------|-------------|-------------|
| POST | /users | ADMIN | Create new user |
| GET | /users | Authenticated | List all users |
| GET | /users/{id} | Authenticated | Get user details |
| PUT | /users/{id} | ADMIN | Update user |
| DELETE | /users/{id} | ADMIN | Delete user |

📂 Financial Records (/records)

| Method | Endpoint | Access Role | Description |
|--------|----------|-------------|-------------|
| POST | /records | ADMIN | Create a new financial entry |
| GET | /records | Authenticated | Retrieve all records |
| GET | /records/{id} | Authenticated | Retrieve record by ID |
| PUT | /records/{id} | ADMIN | Update financial record |
| DELETE | /records/{id} | ADMIN | Delete a record |
| GET | /records/type/{type} | ADMIN, ANALYST | Filter by INCOME or EXPENSE |
| GET | /records/category/{category} | Authenticated | Filter by category |
| GET | /records/date | Authenticated | Filter by date range |

📊 Dashboard & Analytics (/dashboard)

| Method | Endpoint | Access Role | Description |
|--------|----------|-------------|-------------|
| GET | /dashboard/total-income | ADMIN, ANALYST, VIEWER | Get the sum of all income records |
| GET | /dashboard/total-expense | Authenticated | Get the sum of all expense records |
| GET | /dashboard/net-balance | Authenticated | Get the total net balance (Income - Expense) |
| GET | /dashboard/category-wise | Authenticated | Get totals grouped by category |
| GET | /dashboard/recent | Authenticated | Get the 5 most recent financial activities |

---


## Design Decisions & Assumptions
- Security: Implemented NoOpPasswordEncoder for simplicity during the assessment. In a production environment, BCryptPasswordEncoder would be used.
- Persistence: Used Postgres for "Plug-and-Play" evaluation. The configuration can be switched to MySQL/H@ by simply changing the application.properties.
- Data Processing: Dashboard calculations are performed using Java Streams for readability, but optimized Repository queries are used for filtering.
- Error Handling: A GlobalExceptionHandler ensures that the API returns clean, structured JSON error messages instead of stack traces.

---

## 👩‍💻 Author
Ashika M
