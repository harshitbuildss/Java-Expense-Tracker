


# Smart Expense Tracker REST API

A backend expense management application built using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. The project follows a layered architecture and exposes RESTful APIs for managing income and expenses, transaction analysis, and dashboard insights.

---

## Features

- Add a new expense or income entry
- View all transactions
- Filter transactions by type, category, keyword, and date range
- Sort transactions by amount or date
- View a transaction by ID
- Update existing transactions
- Delete transactions
- Search transactions
- Category-wise expense summary
- Dashboard summary including:
  - Total income
  - Total expenses
  - Current balance
  - Net savings
  - Total transactions
  - Average expense
  - Category breakdown
  - Monthly income/expense breakdown
- Bean validation for request data
- Global exception handling
- DTO-based dashboard responses
- Automatic persistence using MySQL

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Postman

---

## Project Structure

```text
src/main/java
│
├── controller
├── dto
├── model
├── repository
├── service
└── ExpensetrackerApplication
````

The application follows a layered architecture:


Controller
    ↓
Service
    ↓
Repository
    ↓
Hibernate / JPA
    ↓
MySQL


---

## API Endpoints

| Method | Endpoint                                               | Description                                              |
| ------ | ------------------------------------------------------ | -------------------------------------------------------- |
| POST   | `/api/expenses`                                        | Add a new expense                                        |
| POST   | `/api/expenses/income`                                 | Add a new income entry                                   |
| GET    | `/api/expenses`                                        | Get all transactions with optional filtering and sorting |
| GET    | `/api/expenses/{id}`                                   | Retrieve a transaction by ID                             |
| PUT    | `/api/expenses/{id}`                                   | Update a transaction                                     |
| DELETE | `/api/expenses/{id}`                                   | Delete a transaction                                     |
| GET    | `/api/expenses/search?category=&type=&keyword=`        | Search transactions                                      |
| GET    | `/api/expenses/summary`                                | Get category-wise expense totals                         |
| GET    | `/api/expenses/dashboard`                              | Get complete dashboard data                              |
| GET    | `/api/expenses/sorted?by=amount\|date&order=asc\|desc` | Sort transactions                                        |

### Transaction Filtering

The main transaction endpoint supports optional parameters:

type
category
keyword
startDate
endDate
sortBy
order


This allows the frontend to retrieve exactly the data required for transaction lists, analytics, and dashboard visualizations.

---

## Dashboard API

The `/api/expenses/dashboard` endpoint provides the data required for the Smart Expense Tracker dashboard.

It includes:

* Total Income
* Total Expenses
* Current Balance
* Net Savings
* Total Transactions
* Average Expense
* Category-wise Expense Breakdown
* Monthly Income and Expense Breakdown

This allows the frontend to generate charts, summaries, and financial insights using real backend data.

---

## Database

The application uses **MySQL** with Spring Data JPA and Hibernate for persistence.

The main transaction data contains:

id
amount
category
date
description
type

Where `type` can be:


INCOME
EXPENSE


Existing expense records are maintained as `EXPENSE` transactions.

---

## Architecture


React / Postman
      │
      ▼
 REST API
      │
      ▼
@RestController
      │
      ▼
 Service Layer
      │
      ▼
 Repository Layer
      │
      ▼
 Spring Data JPA
      │
      ▼
 Hibernate
      │
      ▼
 MySQL


---

## Skills Demonstrated

* Object-Oriented Programming (OOP)
* Layered Architecture
* REST API Development
* CRUD Operations
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* MySQL Integration
* Repository Pattern
* Dependency Injection
* DTO Design
* Bean Validation
* Global Exception Handling
* Query Filtering and Sorting
* Dashboard Data Aggregation
* Maven Project Management
* API Testing with Postman

---

## Future Improvements

* Swagger / OpenAPI documentation
* Pagination for large transaction lists
* Budget tracking and alerts
* Authentication and authorization
* Advanced financial analytics
* React-based interactive frontend dashboard

---

## Author

**Harshit Kumar Singh**

Backend Developer | Java | Spring Boot | MySQL | REST APIs | DSA

```
```
