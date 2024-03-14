# Microservices with Spring and Springboot

## Technologies

- Spring Cloud (Eureka)
- Spring Cloud Config
- Spring Cloud Gateway
- Spring Data Rest
- Feign Client
- Spring Data JPA

## Requirements

- Java 17
- Spring Boot 3.2.3

## How to run
    >> NOTE : Make sure the server port is available (Tips: Check on Command Prompt "netstat -aon")
    >> NB : Development on this project is still ongoing.
1. Run Discovery Server Module
2. Run Gateway Server Module
   - Note: before run config server make sure the configserver refer to your github repository
   - You can check this out https://github.com/leosiagiann/configuration-microservice
3. Run Config Server Module 
4. Run Product Service
5. Run User Service
6. Run Transaction Service