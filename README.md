Food Delivery Management System

A web-based Food Delivery Management System developed using Java, Spring Boot, MySQL, Spring Data JPA, Spring Security, and Thymeleaf.

The application allows users to register, log in, browse restaurants, search and filter restaurants, view restaurant details, and manage restaurant information. It provides a structured backend using Spring Boot and a MySQL database for persistent data storage.

Features

User Features

- User registration
- User login and authentication
- Secure password handling
- User details stored in MySQL
- Restaurant listing
- Restaurant search
- Cuisine-based filtering
- Restaurant details

Restaurant Management

- View all restaurants
- Search restaurants by name
- Filter restaurants by cuisine
- View restaurant details
- Add new restaurants
- Delete restaurants
- Store restaurant information in MySQL

Security

- Spring Security authentication
- Role-based user management
- Protected application pages
- BCrypt password encryption

Technologies Used

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Hibernate
- Maven
- HTML
- Git & GitHub
- IntelliJ IDEA

Project Architecture

The project follows a layered architecture:

Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
MySQL Database

Controller Layer

Handles HTTP requests and connects the web pages with the application logic.

Examples:

UserController
RestaurantController

Service Layer

Contains the business logic of the application.

Examples:

UserService
RestaurantService

Repository Layer

Uses Spring Data JPA to communicate with the database.

Examples:

UserRepository
RestaurantRepository

Entity Layer

Represents database tables as Java classes.

Examples:

User
Restaurant

View Layer

Thymeleaf HTML templates are used to create the application's user interface.

Examples:

login.html
register.html
restaurant-list.html
restaurant-details.html
add-restaurant.html

Restaurant Features

The restaurant module provides the following URL mappings:

GET  /restaurant/list
GET  /restaurant/{id}
GET  /restaurant/add
POST /restaurant/save
GET  /restaurant/delete/{id}

Restaurant Search

Users can search for restaurants using the restaurant name.

Example:

/restaurant/list?search=Pizza

Cuisine Filtering

Restaurants can also be filtered according to cuisine.

Supported examples include:

Indian
Chinese
Italian
South Indian
North Indian

Example:

/restaurant/list?cuisine=Indian

Database

The application uses MySQL for persistent data storage.

Main database information includes:

Users
Restaurants

The application communicates with MySQL using:

- Spring Data JPA
- Hibernate
- MySQL Driver

Running the Project

1. Clone the repository

git clone https://github.com/Geetanjali-png/fooddelivery.git

2. Open the project

Open the project in IntelliJ IDEA.

3. Configure MySQL

Create the required MySQL database and configure the database credentials in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/fooddelivery
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false

Replace "YOUR_PASSWORD" with your MySQL password.

4. Run the application

Run:

FooddeliveryApplication.java

The application will start on:

http://localhost:8080

Main Application Pages

Home
Login
Registration
Restaurant List
Restaurant Details
Add Restaurant

Restaurant listing:

http://localhost:8080/restaurant/list

Add restaurant:

http://localhost:8080/restaurant/add

Error Handling

During development, database and application errors were identified and resolved using Spring Boot logs and Hibernate error messages.

For example, duplicate email registration is prevented by the unique email constraint in the "users" table.

GitHub

The source code is maintained in a public GitHub repository:

https://github.com/Geetanjali-png/fooddelivery

Learning Outcomes

Through this project, I gained practical experience in:

- Spring Boot application development
- MVC architecture
- Spring Data JPA
- MySQL database integration
- Hibernate ORM
- Spring Security
- User authentication
- Thymeleaf templates
- CRUD operations
- Search and filtering
- REST-style URL mapping
- Maven project management
- Git and GitHub
- Debugging Spring Boot applications

Future Enhancements

The system can be extended with:

- Food/menu management
- Shopping cart
- Online ordering
- Order tracking
- Payment integration
- Customer reviews and ratings
- Admin dashboard
- Restaurant owner dashboard
- Delivery partner management
- REST APIs
- Cloud deployment

Conclusion

The Food Delivery Management System demonstrates how a Java-based full-stack application can be developed using Spring Boot, Spring Security, Thymeleaf, JPA, Hibernate, and MySQL.

The project provides a foundation for a complete food delivery platform and demonstrates practical implementation of authentication, database management, CRUD operations, search, filtering, and web-based user interaction.
