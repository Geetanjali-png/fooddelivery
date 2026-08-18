🍔 Food Delivery Management System

A web-based Food Delivery Management System developed using Spring Boot, MySQL, Spring Data JPA, Thymeleaf, Spring Security, HTML, CSS, and JavaScript.

🚀 Features

- User registration and login
- Secure user authentication
- Password encryption using BCrypt
- Browse restaurants
- View restaurant details
- Browse menu items
- Add food items to cart
- Update cart quantity
- Remove items from cart
- Place food orders
- Manage user orders
- Restaurant and menu management
- MySQL database integration

🛠️ Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security
- MySQL
- Thymeleaf
- HTML
- CSS
- JavaScript
- Maven
- IntelliJ IDEA

🏗️ Project Architecture

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

📂 Project Structure

src/
├── main/
│   ├── java/
│   │   └── com.geetanjali.fooddelivery/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── service/
│   │       └── security/
│   │
│   └── resources/
│       ├── templates/
│       ├── static/
│       └── application.properties
│
└── test/

🗄️ Database

The application uses MySQL as the database.

Main entities include:

- User
- Restaurant
- MenuItem
- Cart
- Order
- OrderItem

⚙️ Configuration

Configure the MySQL database in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/fooddelivery
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false

▶️ How to Run

1. Create a MySQL database named "fooddelivery".
2. Configure the database username and password in "application.properties".
3. Open the project in IntelliJ IDEA.
4. Build the project using Maven.
5. Run "FooddeliveryApplication.java".
6. Open the application in your browser:

http://localhost:8080

🔐 Security

Spring Security is used for:

- User authentication
- Password encryption
- Login and logout
- Protected application pages
- Authorization

Passwords are securely stored using BCryptPasswordEncoder.

🍕 Application Flow

User Registration/Login
        ↓
Browse Restaurants
        ↓
Select Restaurant
        ↓
View Menu
        ↓
Add Food Items to Cart
        ↓
Manage Cart
        ↓
Place Order
        ↓
Order Confirmation

🎯 Project Objective

The objective of this project is to develop a complete online food delivery application where users can securely register, browse restaurants and menu items, add food to their cart, and place orders.

🔮 Future Enhancements

- Online payment integration
- Restaurant search and filtering
- Food ratings and reviews
- Order tracking
- Delivery partner management
- Real-time order status
- Email/SMS notifications
- Offers and coupons
- Admin dashboard
- Responsive mobile UI

👩‍💻 Author

Geetanjali

Information Science Engineering Student
