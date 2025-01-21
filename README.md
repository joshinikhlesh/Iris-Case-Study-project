E-Commerce Microservices Project
This is a multi-module Spring Boot-based microservices project designed for an e-commerce platform. The system is designed with various microservices to handle different functionalities such as user management, product catalog, payment processing, authentication, and API Gateway. All services are connected through Spring Cloud components, including Service Registry (Eureka) and Config Server.

Table of Contents
Project Overview
Technologies Used
Service Descriptions
Prerequisites
Setup and Installation
Running the Project
Testing and API Calls
Docker Setup

Project Overview
This project consists of several Spring Boot microservices that work together to manage an e-commerce platform's functionalities. The system is designed to be scalable, fault-tolerant, and resilient, leveraging Spring Cloud for service discovery and centralized configuration.

Services:
Config Server: Manages the configuration for all microservices in the project.
Service Registry (Eureka Server): Registers and discovers all services in the system.
User Service: Manages user information.
User-authentication-service: Manages user authentication and authorization.
Product Service: Manages the product catalog.
Card validation service: Handles payment card information.
Payment Service: Manages the payment process.
API Gateway: Serves as a single entry point to all the microservices.
Authentication Service: Handles user authentication and authorization.

Technologies Used
Spring Boot: For building microservices.
Spring Cloud: For service discovery and configuration management.
Eureka Server: Service registry and discovery.
Spring Cloud Config: Centralized configuration server.
Spring Security: Authentication and authorization management.
Spring Cloud Gateway: API Gateway for routing requests to appropriate services.
Docker: Containerization of services for easy deployment.

Service Descriptions
1. Config Server
   Manages external configuration for the microservices.
   Uses Git or local file-based configuration sources.
2. Service Registry (Eureka Server)
   A central registry for all the microservices.
   Microservices register themselves with the Eureka server for discovery.
3. User Service
   Handles user-related operations such as registration, login, and profile management.
   Connects with Authentication Service for user authentication.
4. Product Service
   Manages product-related data such as catalog information, product details, etc.
   Exposes endpoints for managing products.
5. Card validation Service
   Handles credit/debit card information securely.
   Provides endpoints for storing and validating card data.
6. Payment Service
   Handles the payment process, including transactions.
   Integrates with payment gateways and processes payment transactions.
7. API Gateway
   Provides a unified entry point for all services.
   Routes API calls to the appropriate microservices based on request paths.
8. Authentication Service
   Handles user authentication using JWT or OAuth tokens.
   Integrates with User Service for user credentials validation.
   Prerequisites
   Java 17 or later
   Maven or Gradle for building the project
   Docker for containerization (optional)
   MySQL for database (or another relational database service)
   Git for version control

Setup and Installation

Clone the repository:
git clone
https://github.com/joshinikhlesh/Iris-Case-Study-project.git

Install dependencies (for Maven):
mvn clean install
Configure application properties:
Update the application.yml or application.properties in each service module to reflect correct database credentials, Eureka server URLs, and other configuration details.
Make sure the Config Server is configured properly to serve the centralized configuration.

Running the Project
You can run the microservices locally using Spring Boot's mvn spring-boot:run command or by using Docker Compose to run all services together.

Start Config Server:

cd config-server
mvn spring-boot:run

Start Eureka Service Registry:

cd service-registry
mvn spring-boot:run

Start User Service:

cd user-service
mvn spring-boot:run

Start Product Service:

cd product-service
mvn spring-boot:run

Start Card Service:



cd card-service
mvn spring-boot:run

Start Payment Service:

cd payment-service
mvn spring-boot:run

Start API Gateway:


cd api-gateway
mvn spring-boot:run

Start Authentication Service:
cd authentication-service
mvn spring-boot:run

Docker Setup
1. All microservice have a specifc DockerFile available.
2. Created a docker-compose.yml file at the root of the project with definitions for each service.
   Run the services using:

   docker-compose up -d
   This will build and start all containers for the services defined in the docker-compose.yml file.
   Once all services are up and running, you can test the endpoints by making HTTP requests to:

Eureka Dashboard: http://localhost:8761
Config Server: http://localhost:8888
User Service: http://localhost:8083
Product Service: http://localhost:8084
Card Service: http://localhost:8087
Payment Service: http://localhost:8086
API Gateway: http://localhost:8081
Authentication Service: http://localhost:8082
Testing and API Calls