# ToDo List Application

A **Spring Boot-based ToDo List application** with JWT authentication and role-based access control. This application allows users to register, log in, and manage their to-do tasks, supporting CRUD operations. It is designed with production-ready architecture, including security, exception handling, and a modular structure for scalability.

## Features
- User authentication using JWT.
- Role-based access control (admin/user roles).
- CRUD operations for managing to-do items.
- Layered architecture with separation of concerns.
- Custom exception handling.
- Security configurations using Spring Security.

## Technology Stack
- **Java 21**
- **Spring Boot 3.3.5**
- **Spring Security 6**
- **JWT (JSON Web Tokens) 0.11.2**
- **JPA/Hibernate** (for database interactions)
- **MySQL/PostgreSQL 16** (configurable database)
- **Maven** (for dependency management)

## Project Structure
```plaintext
src/main/java/com/niladri/todo/
├── config          # Application configuration (JWT, security, etc.)
├── controller      # REST controllers for handling API requests
├── dto             # Data Transfer Objects (request and response models)
├── exception       # Custom exceptions and global exception handling
├── mapper          # (Optional) Mapper classes for DTO to entity conversion
├── model           # Domain models/entities (User, Todo, etc.)
├── repository      # Repository interfaces for database access
├── security        # Security-related classes (filters, services)
├── service         # Business logic and service classes
├── utility         # Utility/helper classes (e.g., JWT utility)
└── ToDoListApplication.java # Main Spring Boot application class
```

## API Endpoints

### Authentication
- **POST** `/auth/login` – Log in with username and password to receive a JWT token.
- **POST** `/auth/register` – Register a new user.

### ToDo Items
- **GET** `/todos` – Get all ToDo items for the authenticated user.
- **POST** `/todos` – Create a new ToDo item.
- **PUT** `/todos/{id}` – Update an existing ToDo item.
- **DELETE** `/todos/{id}` – Delete a ToDo item.

## Getting Started

### Prerequisites
- Java 21
- Maven
- PostgreSQL database setup

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/nil-official/to-do-list.git
   cd to-do-list

2. Configure the database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/todolistdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Build the application:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn to-do-list:run
   ```

### Testing APIs
- You can test the APIs using tools like **Postman** or **cURL**.
- For authentication, pass the JWT token as a `Bearer Token` in the request headers.

## Security
- **JWT Authentication**: Users must be authenticated with a JWT token to access secured endpoints.
- **Role-based Access**: The application supports multiple user roles (admin, user) to restrict access based on user privileges.

## Future Enhancements
- Implement pagination for fetching to-do items.
- Add user profile management (e.g., updating user details).
- Add integration with front-end frameworks (e.g., Angular or React).

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
