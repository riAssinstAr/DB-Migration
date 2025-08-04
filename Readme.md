# Postgres SQL to MongoDB Database Migration Tool

A user focused Postgres SQL to MongoDB database migration tool built with Java and Spring Boot that uses incremental migration technique triggered by user login.

## Prerequisites

    Java 21 JDK (for local builds)

    Maven 3.x

    Docker & Docker Compose

    Supabase PostgreSQL URL

    MongoDB Atlas URI

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
    SUPABASE_DB_URL=your_supabase_url

    # MongoDB Atlas
    MONGODB_URI=your_mongodb_atlas_uri
```

Build the project

```bash
  docker compose build
```

Start the server

```bash
  docker compose up
```
