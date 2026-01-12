# 🚀 TeamFlow Backend

TeamFlow is a secure, production-style **multi-tenant backend system** built with **Java, Spring Boot, and PostgreSQL**, featuring **JWT-based authentication**, **role-based authorization**, and clean REST APIs.

This project demonstrates how real-world backend systems handle **users, organizations, security, and access control** — not just CRUD.

---

 ✨ Why This Project Matters

Most backend projects stop at CRUD.

**TeamFlow goes further**:
- Implements **stateless authentication** using JWT
- Enforces **role-based access control**
- Uses **Spring Security filter chains**
- Integrates with **PostgreSQL**
- Designed with **real production patterns**

This is the kind of backend architecture used in **SaaS products**.

---

 🧠 Core Features

 🔐 Authentication & Security
- Secure login using email & password
- Passwords stored using **BCrypt hashing**
- **JWT tokens** for stateless authentication
- Custom JWT filter integrated into Spring Security

 👥 User Management
- Users belong to an organization
- Roles supported: `ADMIN`, `MEMBER`
- Only authorized roles can access protected endpoints

 🏢 Organization Management
- Create and manage organizations
- Multi-tenant ready design
- Role-based access to organization data

 🛡 Authorization
- Fine-grained API protection
- Token-based access via `Authorization: Bearer <token>`
- Endpoints secured using Spring Security

---

## 🏗 Architecture Overview

Controller → Service → Repository → Database
↓
Spring Security
↓
JWT Filter


- **Controller Layer**: REST APIs
- **Service Layer**: Business logic
- **Repository Layer**: JPA + PostgreSQL
- **Security Layer**: JWT + Spring Security

---

## 🧰 Tech Stack

| Category        | Technology |
|----------------|------------|
| Language        | Java 17 |
| Framework       | Spring Boot |
| Security        | Spring Security + JWT |
| Database        | PostgreSQL |
| ORM             | Spring Data JPA (Hibernate) |
| Build Tool      | Maven |
| API Style       | REST |

---

## 🔑 Authentication Flow (JWT)

1. User logs in via `/api/auth/login`
2. Server validates credentials
3. JWT token is generated and returned
4. Client sends token in `Authorization` header
5. JWT filter validates token for protected APIs

Authorization: Bearer <JWT_TOKEN>

---

## 📡 API Overview

### Auth
- `POST /api/auth/login` – Login & get JWT

### Organizations
- `GET /api/organizations` – List organizations (secured)
- `POST /api/organizations` – Create organization (ADMIN only)

### Users
- `GET /api/users` – List users (secured)
- `POST /api/users` – Create user

---

## ▶️ How to Run Locally

### 1️⃣ Prerequisites
- Java 17+
- PostgreSQL
- Maven

### 2️⃣ Create Database
```sql
CREATE DATABASE teamflow;

3️⃣ Configure Database

Update application.yml with your DB credentials.

4️⃣ Run Application
mvn clean install
mvn spring-boot:run

Server runs on:
http://localhost:8081

🧪 Demo Flow (Recommended)

Login using /api/auth/login
Receive JWT token
Call secured APIs using:

Authorization: Bearer <token>
This flow is fully functional and tested.

📌 Key Learnings & Highlights

Built JWT authentication from scratch
Implemented custom security filters
Debugged real Spring Security issues (401 / 403)
Designed a scalable backend structure
Production-style error handling & access control

🚀 Future Enhancements

Refresh tokens
Pagination & filtering
Docker support
API rate limiting
Audit logs

👨‍💻 Author

Dhruv Redhu
Software Engineer | Backend Development
Java • Spring Boot • PostgreSQL • Security

⭐ Final Note

This project reflects real backend engineering, not just academic code.

If you’re reviewing this as a recruiter:

This candidate understands authentication, authorization, and backend architecture — not just syntax.


