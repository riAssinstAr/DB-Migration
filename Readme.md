# Postgres SQL to MongoDB Database Migration Tool

A user focused Postgres SQL to MongoDB database migration tool built with Java and Spring Boot that uses incremental migration technique triggered by user login.

## Prerequisites

    Java 21 JDK (for local builds)

    Maven 3.x

    Docker & Docker Compose

    Supabase PostgreSQL URL, user, password

    MongoDB Atlas URI, user, password

    .env file to store environment variables

## Run Locally

Clone the project

```bash
  git clone https://github.com/riAs-g/DB-Migration
```

Go to the project directory

```bash
  cd DB-Migration
```

Place your environment secrets in a .env file in the project root:

```dotenv
    # Supabase PostgreSQL
    SUPABASE_HOST=xyz.supabase.co
    SUPABASE_PORT=your_supabase_port
    SUPABASE_DB_USER=your_supabase_user
    SUPABASE_DB_PASS=your_supabase_password

    # MongoDB Atlas
    MONGODB_USER=your_mongo_user
    MONGODB_PASS=your_mongo_password
```

Build the project

```bash
  mvn clean install
```

Start the server

```bash
  mvn sprin-boot:run
```
