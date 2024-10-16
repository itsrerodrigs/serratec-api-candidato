# Curriculum Management API 💻

## Objective
This API is developed as part of an individual assessment for the RESTful API course in the Full Stack Development program at Serratec. The purpose of the API is to manage the information of candidates applying for jobs in a recruitment process.

## Technologies Used
- **Java** (version 17)
- **Spring Boot** (with Spring Web, Spring Data JPA, and DevTools)
- **PostgreSQL** (database)
- **Eclipse IDE** (development environment)
- **Postman** (for API testing)

## Features
- CRUD operations for managing candidate information
- Data exchange in JSON format via HTTP
- Mapped entities and enums for `Candidates`, `Job Positions`, `Education Levels`, and `Curriculum Status`
- DTOs for controlled data transfer
- Derived queries to search candidates by job position and education level

## Data Model

### 1. Candidate Entity
The main entity representing a candidate. It includes the following attributes:
- `name` (String)
- `dateOfBirth` (LocalDate)
- `cpf` (String)
- `education` (Enum: MEDIO, FUNDAMENTAL, GRADUACAO, POS_GRADUACAO, ESPECIALIZACAO)
- `desiredPosition` (Enum: ANALYST, QA, DEV, TECH_LEAD, SUPPORT, UX)
- `curriculumStatus` (Enum: UNDER_REVIEW, REJECTED, APPROVED)

### 2. Enums
- **Education Levels**: `MEDIO`, `FUNDAMENTAL`, `GRADUACAO`, `POS_GRADUACAO`, `ESPECIALIZACAO`
- **Job Positions**: `ANALYST`, `QA`, `DEV`, `TECH_LEAD`, `SUPPORT`, `UX`
- **Curriculum Status**: `UNDER_REVIEW`, `REJECTED`, `APPROVED`

## Layers and Architecture

### 1. DTO (Data Transfer Object)
DTOs are used to ensure secure and controlled data transfer between the client and server. They prevent data leaks and maintain separation between the presentation and business logic layers.

### 2. Repository
Repository interfaces provide basic CRUD operations for the entities using Spring Data JPA. Derived queries allow filtering candidates based on their desired job position and education level.

### 3. Services
The service layer implements the business logic. This includes operations such as adding new candidate profiles, updating curriculum statuses, and more.

### 4. Controllers
Controllers handle HTTP requests and map them to the corresponding services. Key annotations used:
- `@RestController`
- `@RequestMapping`
- `@GetMapping`
- `@PostMapping`

## Endpoints

### Candidates
- **GET** `/candidates`: Retrieve all candidate profiles
- **POST** `/candidates`: Add a new candidate profile
- **PUT** `/candidates/{id}`: Update an existing candidate profile
- **DELETE** `/candidates/{id}`: Delete a candidate profile
- **GET** `/candidates?desiredPosition={position}`: Find candidates by job position
- **GET** `/candidates?education={education}`: Find candidates by education level

# API Testing Guide

## How to Test the Curriculum Management API

This guide provides detailed steps for testing the Curriculum Management API using **Postman**.

### Prerequisites:
- Ensure the Spring Boot application is running on your local machine.
- Postman installed to send HTTP requests.

### Step 1: Open Postman

1. Open **Postman** on your system.
2. Create a new **POST** request to add a new candidate.

### Step 2: Set Up the Request

1. In Postman, enter the URL for your **POST** request.
   Example: http://localhost/candidatos

3. Select the **Body** tab, then choose **raw** and set the format to **JSON**.

### Step 3: Enter the Candidate Data

1. Copy and paste the following JSON object into the request body:

 ```json
 {
     "id": 4,
     "nomeCandidato": "Fernanda Oliveira",
     "dataNascimento": "1995-01-15",
     "cpf": "45678912322",
     "escolaridade": "POS_GRADUACAO",
     "vagaDesejada": "TECH_LEAD",
     "statusCurriculo": "EM_ANALISE"
 }
 ```

2. Make sure the JSON format is correct and all required fields are present.

### Step 4: Send the Request

1. Click the **Send** button in Postman.
2. You should see a response from the API confirming that the candidate has been successfully added.

### Additional Requests

After adding candidates, you can perform other CRUD operations using Postman:

- **GET** `/candidates`: Retrieve a list of all candidates.
- **PUT** `/candidates/{id}`: Update the information of a specific candidate.
- **DELETE** `/candidates/{id}`: Remove a candidate from the system.

Make sure to replace `{id}` with the actual candidate ID in your requests for update or delete operations.

