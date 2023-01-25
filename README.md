# Library Management System

This is a library management system built using clean architecture and the Spring framework with Kotlin. It allows for the management of books, including querying for books, checking availability, exporting books and renting books.

## Architecture

The application is separated into four layers:
- Presentation layer: handles the incoming HTTP requests and maps them to the appropriate use cases in the application layer.
- Application layer: contains the use cases and use case invokers
- Domain layer: contains the business logic, entities and data models for the application.
- Infrastructure layer: provides implementations for interfaces defined in the domain layer, such as interacting with a database.

## Features
- Importation of books: Allows for the addition of new books to the library's inventory.
- Exportation of books: Allows for the removal of books from the library's inventory
- Querying for books: Allows for searching and retrieving books based on various criteria such as title, author, and publication date.
- Checking availability: Allows for checking the availability of a specific book.
- Renting books: Allows renters to rent a book, which removes it from the available inventory for the duration of the rental.

## Testing

The application is well-tested with a code coverage of over 95%. Tests are written for all the modules in the application.

## How to run

To run the application, you will need to have the following installed:
- Java 17 or later
- Kotlin
- Gradle
- A database management system (e.g., MySQL, PostgreSQL)
- Docker

1. Clone the repository
2. Run the command `docker-compose up` to start the application and the database.
3. The application will be running on `http://localhost:9000/`