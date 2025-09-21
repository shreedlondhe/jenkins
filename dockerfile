# Stage 1: Build the jar
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build fat jar with dependencies
RUN mvn clean package assembly:single

# Stage 2: Run tests using fat jar
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/MyFramework-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Run TestNG from inside the jar using the XML included in resources
CMD ["java", "-cp", "app.jar", "org.testng.TestNG", "classpath:testng.xml"]
