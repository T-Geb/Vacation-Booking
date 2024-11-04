# Vacation Booking Backend

*This project was developed as part of a backend programming course. The front end and database schema were pre-existing and provided by the course.*

## Project Overview
A backend system for managing vacation bookings, developed using Java and Spring Boot. It handles essential business logic, including customer management, order processing, and entity relationships.
## Technologies Used
- **Java 17**: Core programming language
- **Spring Boot**: Framework for building RESTful APIs
- **JPA/Hibernate**: ORM for database interactions
- **MySQL**: Database for data storage

## Key Features
- Handles data relationships like One-to-Many, Many-to-One, and Many-to-Many
- Basic input validation and error handling
- Generates unique order tracking numbers for vacation bookings
- Cross-origin support to integrate with a front-end client
- Uses Bootstrap data to populate the database with initial sample entries

## Implementation Summary
- Defined entity classes with JPA annotations to map database tables
- Created repositories for data access and basic CRUD operations
- Developed order processing and validation logic in the service layer
- Built RESTful endpoints to handle requests from the client
