FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:2
COPY --from=build /target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]