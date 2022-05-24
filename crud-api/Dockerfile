FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew clean build
RUN cp /app/build/libs/crud-api-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "application.jar"]