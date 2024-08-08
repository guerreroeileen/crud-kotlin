FROM openjdk:21-jdk-slim

COPY build/libs/crud-kotlin-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

ENV DB_HOST=localhost
ENV DB_PORT=5432
ENV DB_NAME=crud-kotlin
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=admin

ENTRYPOINT ["java", "-jar", "app.jar"]