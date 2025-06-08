# Use official OpenJDK base image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy the jar file into the container
COPY target/migration-0.0.1-SNAPSHOT.jar migration.jar

# Expose port
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "migration.jar"]