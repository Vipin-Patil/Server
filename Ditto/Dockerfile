FROM maven:3.8.5-openjdk-17-slim as build
WORKDIR /app
COPY Ditto/pom.xml .
RUN mvn dependency:go-offline
COPY Ditto/src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]