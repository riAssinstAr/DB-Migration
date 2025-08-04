FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/migration-0.0.1-SNAPSHOT.jar migration.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "migration.jar"]