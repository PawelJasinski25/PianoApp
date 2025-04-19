# Piano App

A web application built with Java Spring Boot, Thymeleaf, and CSS to help pianists keep track of the pieces they know and encourage regular practice. The application allows users to maintain a personal list of known compositions and provides statistics on how often each piece has been played. New functionalities are being gradually added as the project develops.

## Features
- **Personal list of known compositions**: Add, view, and manage the pieces you know.
- **Statistics**: Track how often each piece has been played and monitor your practice progress.
- **User interface**: Built using Thymeleaf and styled with CSS for a clean, interactive experience.

## Setup Instructions

### 1. Clone the Repository
First, clone the repository to your local machine.

```bash
git clone https://github.com/PawelJasinski25/PianoApp.git
```


### 2. Database Configuration

The application uses a MySQL database. You need to set up a local MySQL database and configure the application to connect to it.

#### Step 1: Create the Database

You can use the provided SQL files:

- `schema.sql` – contains the table structure for the application.
- `seed.sql` – contains sample data to populate the database.


#### Step 2: Configure `application.properties`

Update the `application.properties` file located in `src/main/resources` to match your MySQL setup


### 3. Build and Run the Application

#### Using Maven (Command Line)

Build the application:

```bash
mvn clean install
```
Run the application:

```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080 by default.

