# Library Management System

A console-based Library Management System built using core Java concepts including Object-Oriented Programming (OOP), Collections, Exception Handling (via Input Validation), and composition.

## Architecture

The project follows a structured package architecture:

### `com.Library.model`
Contains the core data structures and domain logic.
- **User**: Base class containing user properties (`userId`, `name`).
- **Member**: Inherits from `User`, adds `membershipId`, and tracks a list of borrowed `Book` objects. Limits borrowing to a maximum of 3 books.
- **Book**: Represents literary items in the library, tracking `bookId`, `title`, `author`, `publicationDate`, availability, and the current borrower.
- **Transaction**: Tracks the lifecycle of borrowing events, linking a `Book` and a `Member` along with an issue date and return date.

### `com.Library.service`
Handles the business logic and state management.
- **Library**: Acts as the central hub managing lists of `allBooks`, `allMembers`, and `allTransactions`. It contains methods to add/remove entities, process book issues/returns, and generate system statistics.

### `com.Library.util`
Utility classes for application-wide tasks.
- **InputValidator**: A robust and reusable `Scanner` wrapper that prevents crashes (e.g., `InputMismatchException`) when users provide invalid data types. It ensures clean data entry for integers, long IDs, and strings.

### `com.Library`
The application's entry point.
- **Main**: Houses the `main` method and provides a cohesive, interactive console menu for users to interact with the underlying `Library` service.

## Features
- **Book Management**: Add, update, remove, search, and view library inventory.
- **Member Management**: Register, remove, and view library members.
- **Borrowing System**: Check out and return books with active tracking of who has what.
- **Transactions & Statistics**: Keep an audit of all active/past transactions along with real-time statistics (total/available/borrowed counts).

## How to Run

1. Open a terminal and navigate to the project's root folder (`Library Management system`).
2. Compile the system by running:
   ```bash
   javac com/Library/model/*.java com/Library/service/*.java com/Library/util/*.java com/Library/Main.java
   ```
3. Run the application:
   ```bash
   java com.Library.Main
   ```
