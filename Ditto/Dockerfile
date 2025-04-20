FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Ditto-0.0.1-SNAPSHOT.jar Ditto-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Ditto-0.0.1-SNAPSHOT.jar"]