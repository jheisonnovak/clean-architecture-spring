# Clean Architecture Example with Spring Boot

This repository provides an example of implementing **Clean Architecture** using [Spring Boot](https://spring.io/projects/spring-boot).

## 🛠 Technologies

-   **Spring Boot**
-   **Spring Data JPA**
-   **H2 Database**

## 📁 Project Structure

The project is structured following a modular approach with a layered architecture, adhering to the principles of **Clean Architecture**:

    src/
    ├── main/
    │   ├── java/com/mycompany/my-application/
    │   │   ├── modules/
    │   │   │   ├── my-module/
    │   │   │   │   ├── application/
    │   │   │   │   │   ├── dtos/
    │   │   │   │   │   ├── mappers/
    │   │   │   │   │   └── usecases/
    │   │   │   │   ├── domain/
    │   │   │   │   │   ├── entities/
    │   │   │   │   │   ├── enums/
    │   │   │   │   │   ├── repositories/
    │   │   │   │   │   └── usecases/
    │   │   │   │   ├── infrastructure/
    │   │   │   │   │   ├── repositories/
    │   │   │   │   │   └── config/
    │   │   │   │   ├── interface/
    │   │   │   │   │   └── controllers/
    │   │   ├── shared/
    │   │   │   ├── ...
    │   └── resources/
    │       └── application.properties
    ├── test/
    │   ├── java/com/mycompany/my-application/
    └── ...

### Key Concepts

-   **Modules**: Each module encapsulates a specific part of the application's domain, such as a `TaskModule`, containing domain entities, repositories, and use cases.
-   **Domain**: Contains core business logic, including **entities**, **enums**, **repositories**, and **services**.
-   **Infrastructure**: Handles database operations and configurations, encapsulating persistence logic.
-   **Application**: Contains **DTOs**, **mappers**, and **use cases** that represent the application's business logic.
-   **Interface**: Exposes the application to the outside world through **controllers**.

## 🚀 Getting Started

### Prerequisites

-   **Java** (version 17 or higher)
-   **Maven**

### Installation

1. Clone this repository:

    ```bash
    git clone https://github.com/JheisonNovak/clean-architecture-spring.git
    cd clean-architecture-spring
    ```

2. Build the project:

    On **Linux/macOS**:

    ```bash
    ./mvnw clean install
    ```

    On **Windows**:

    ```cmd
    mvnw.cmd clean install
    ```

3. Run the application:

    On **Linux/macOS**:

    ```bash
    ./mvnw spring-boot:run
    ```

    On **Windows**:

    ```cmd
    mvnw.cmd spring-boot:run
    ```

4. Access the application:

    Open your browser and navigate to [http://localhost:4000/swagger-ui.html](http://localhost:4000/swagger-ui.html) to explore the API documentation using Swagger UI.

## 📚 Learn More

For more information on the concepts and practices used in this repository:

-   [Spring Boot Documentation](https://spring.io/projects/spring-boot)
-   [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
-   Clean Code: A Handbook of Agile Software Craftsmanship - Robert C. Martin

## 🤝 Contributing

Feel free to submit issues or pull requests. Contributions are welcome!
