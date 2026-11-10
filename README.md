# Social Media Backend

A Social Media Backend application built using Java and Spring Boot. The project provides REST APIs for managing social media posts and is designed to be extended with additional features and microservices.

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA / Hibernate
- **Build Tool:** Maven
- **API Testing:** Postman

## Features

- Create social media posts.
- Associate posts with users.
- Store and retrieve post information from MySQL.
- Automatically generate unique IDs using UUID.
- Track creation and last-update timestamps.
- Follow a layered architecture using Controllers, Services, Repositories, DTOs, and Models.

## Project Structure

```text
src/main/java/org/example/
├── controllers/
│   └── PostController.java
├── services/
│   └── PostService.java
├── Repository/
│   └── PostRepository.java
├── dtos/
│   ├── PostRequestDTO.java
│   └── PostResponseDTO.java
└── models/
    ├── Base.java
    └── Post.java
```

*The structure may evolve as additional features are implemented.*

## Prerequisites

Make sure you have installed:

- Java (compatible with your project's configured version)
- Maven
- MySQL
- Postman (optional, for API testing)

## Database Setup

Create the MySQL database:

```sql
CREATE DATABASE social_media;
```

Configure your database connection using environment variables in `application.properties`:

```properties
server.port=8081

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Set the environment variables before running the application:

```bash
export DB_URL="jdbc:mysql://localhost:3306/social_media"
export DB_USERNAME="root"
export DB_PASSWORD="your_password"
```

**Security:** Never commit actual database passwords, API keys, or other secrets to GitHub.

## Run the Application

Clone the repository:

```bash
git clone <YOUR_REPOSITORY_URL>
cd <YOUR_PROJECT_DIRECTORY>
```

Run the application using the Maven Wrapper, if included:

```bash
./mvnw spring-boot:run
```

Alternatively, run it with Maven:

```bash
mvn spring-boot:run
```

The application will run at:

```text
http://localhost:8081
```

## API Endpoints

### Create a Post

**Method:** `POST`

**Endpoint:**

```text
/v1/post/{userid}
```

**Example request:**

```http
POST http://localhost:8081/v1/post/1
Content-Type: application/json
```

```json
{
  "title": "My First Post",
  "description": "Hello, this is my first social media post!"
}
```

The server processes the request, associates the post with the specified user ID, and saves it to the database.

*Note: The request and response fields should match the DTOs implemented in the project.*

## Database Design

### Post

A post contains the following information:

- `id` — Unique identifier generated using UUID.
- `content` — Content of the post.
- `url` — URL associated with the post.
- `userId` — Identifier of the user who created the post.
- `createdAt` — Timestamp when the post was created.
- `lastUpdatedAt` — Timestamp of the most recent update.

The common fields are inherited from the `Base` model.

## Architecture

The application follows a layered architecture:

1. **Controller:** Handles incoming HTTP requests and responses.
2. **Service:** Contains business logic.
3. **Repository:** Communicates with the database through Spring Data JPA.
4. **Model / Entity:** Represents database entities.
5. **DTOs:** Define the data transferred between API clients and the application.

## Future Enhancements

- User registration and authentication.
- Update and delete posts.
- Retrieve posts by ID and user ID.
- Social media feed.
- Likes and comments.
- Pagination and sorting.
- Input validation and centralized exception handling.
- Microservices integration.

## License

This project is intended for learning and development purposes.
