# Microservices Practice Application

This repository demonstrates the implementation of microservices using Spring Boot. The project is divided into two independent services: **QuizService** and **QuestionService**, each with its own database and functionality, connected through microservices architecture.

## Overview of Microservices Architecture

Microservices architecture breaks down complex applications into smaller, independent services. This enhances scalability and maintainability. Below are the key principles and advantages of microservices:

- **Self-Contained Services**: Applications are divided into self-contained services, each focusing on a specific function, simplifying development and maintenance.
- **Business Feature Focus**: Each microservice handles a specific business feature, such as user authentication or product management, enabling specialized development.
- **API-Based Communication**: Services interact via APIs, ensuring standardized information exchange and integration.
- **Technology Diversity**: Different technologies can be used for each service, allowing teams to select the best tools for their needs.
- **Independent Updates**: Microservices can be updated independently, reducing risks during changes and enhancing system resilience.

## Project Details

### Services

#### 1. QuizService
- **Database**: PostgreSQL
- **Table**: `Quiz`
- Handles all operations related to quizzes.

#### 2. QuestionService
- **Database**: PostgreSQL
- **Table**: `Question`
- Manages all operations related to questions.

### Inter-Microservice Communication

The application demonstrates inter-microservice communication between QuizService and QuestionService. When a user fetches quiz data from QuizService, related questions are included in the response.

#### Communication Mechanism
- **Protocol**: HTTP/HTTPS
- **Communication Type**: RESTful APIs
- **Tool Used**: OpenFeign

OpenFeign is used to simplify communication between services, enabling seamless data exchange and integration.

### Features
1. Fetch quizzes with associated questions in a single API call.
2. Independent services with their own databases for modularity and scalability.
3. Demonstrates the power of microservices architecture using Spring Boot.

## Setup and Execution

### Prerequisites
- Java 17 or higher
- PostgreSQL
- Maven or Gradle
- Spring Boot 3.x

### Steps to Run
1. Clone the repository.
2. Set up PostgreSQL databases for QuizService and QuestionService.
3. Configure database connection properties in the respective `application.properties` or `application.yml` files.
4. Build and run each service using:
   ```bash
   mvn spring-boot:run
   ```
   or
   ```bash
   gradle bootRun
   ```
5. Use APIs to interact with the services.

## API Documentation

### QuizService Endpoints
- **GET /quizzes**: Fetch all quizzes (includes related questions via microservices communication).
- **POST /quizzes**: Create a new quiz.

### QuestionService Endpoints
- **GET /questions**: Fetch all questions.
- **POST /questions**: Create a new question.

## Key Technologies Used
- **Spring Boot**: For creating microservices.
- **PostgreSQL**: As the database for both services.
- **OpenFeign**: For inter-service communication.
- **RESTful APIs**: For service interaction.

## Benefits of Microservices in This Application
1. **Scalability**: Independent scaling of QuizService and QuestionService.
2. **Maintainability**: Easier debugging and updates due to modular design.
3. **Resilience**: Changes in one service do not affect others.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements
- OpenFeign documentation for simplifying inter-microservice communication.
- Spring Boot community for providing robust tools for building scalable applications.

