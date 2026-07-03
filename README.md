# Smart Expense Tracker REST API

A backend expense management application built using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. The project follows a layered architecture and exposes RESTful APIs for performing CRUD operations and expense analysis.



## Features:

- Add a new expense
- View all expenses
- View an expense by ID
- Update existing expenses
- Delete expenses
- Search expenses by category
- Category-wise expense summary
- Sort expenses by amount
- Automatic persistence using MySQL



## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Postman



## Project Structure

```
src/main/java
│
├── controller
├── model
├── repository
├── service
└── ExpensetrackerApplication
```



## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/expenses` | Add a new expense |
| GET | `/api/expenses` | Retrieve all expenses |
| GET | `/api/expenses/{id}` | Retrieve an expense by ID |
| PUT | `/api/expenses/{id}` | Update an expense |
| DELETE | `/api/expenses/{id}` | Delete an expense |
| GET | `/api/expenses/search?category={category}` | Search expenses by category |
| GET | `/api/expenses/summary` | View category-wise expense summary |
| GET | `/api/expenses/sorted` | View expenses sorted by amount |



## Architecture

```
Postman
    │
HTTP Request
    │
@RestController
    │
Service Layer
    │
Repository (Spring Data JPA)
    │
Hibernate
    │
MySQL
```



## Skills Demonstrated

- Object-Oriented Programming (OOP)
- Layered Architecture
- REST API Development
- CRUD Operations
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL Integration
- Repository Pattern
- Dependency Injection
- Exception Handling
- Maven Project Management


## Future Improvements

- Bean Validation (`@Valid`)
- Global Exception Handling
- DTO Layer
- Swagger/OpenAPI Documentation
- Pagination & Sorting
- Budget Alerts
- Authentication & Authorization

---

## Author

**Harshit Kumar Singh**

Backend Developer | Java | Spring Boot | MySQL | REST APIs | DSA
