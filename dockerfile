# Stage 1: Build and cache dependencies
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only pom.xml first to leverage Docker cache
COPY pom.xml .

# Download dependencies only once (cached layer)
RUN mvn dependency:go-offline -B

# Copy all source code
COPY . .

# Optionally, run tests during build (or skip to run later)
 RUN mvn clean test
 # Declare allure-results as a volume
 VOLUME ["/app/target/allure-results"]