FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY Ditto/pom.xml .
RUN mvn dependency:go-offline
COPY Ditto/src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]