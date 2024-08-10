# Spring Boot with Kotlin Project

This is a Spring Boot CRUD project using Kotlin. It is configured for Java version 21 and includes various dependencies for web and database development.

## Description

This project is an example application using Spring Boot to build a web application with Kotlin. The application includes:

- **Spring Boot Starter Data JPA**: For database integration.
- **Spring Boot Starter Web**: For building web applications.
- **Jackson Module Kotlin**: For Kotlin support in Jackson.
- **Springdoc OpenAPI**: For generating OpenAPI documentation.
- **Kotlin Reflect**: Support for Kotlin reflection.
- **PostgreSQL**: Relational database for runtime.
- **Spring Boot DevTools**: Development tools for a better development experience.

## Requirements

- JDK 21 or higher.
- Gradle 8.0 or higher (optional, Gradle Wrapper is included).
- PostgreSQL (if you want to run the application with a PostgreSQL database).

## Project Setup

1. **Clone the Repository**

   Clone this repository to your local machine using:

   ```bash
   git clone https://github.com/guerreroeileen/crud-kotlin.git
   cd crud-kotlin

## Running the Application with Docker
If you prefer to run the application using Docker, follow the steps below.
### Steps
1. Build the Docker Image:

   ```bash
   ./gradlew clean build
   docker-compose up --build

2. Run the Application:

   ```bash
   docker-compose up

The application will be accessible at http://localhost:8080/crud-kotlin/api.

3. Shut Down the Application:

   ```bash
   docker-compose down

### Environment Variables
You can configure the application using the .env file located in the project root. This file is used to pass environment variables to the Docker containers.

### Troubleshooting
- Build Errors: Ensure the JAR file is correctly named (crud-kotlin-0.0.1-SNAPSHOT.jar). If you encounter issues during the build process, verify that the build.gradle.kts configuration is correct.
- Database Connection Issues: Ensure that the PostgreSQL container is running and accessible. Check the logs with docker-compose logs db to diagnose any database-related issues.