FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy only pom.xml first (for dependency caching)
COPY pom.xml .

# Pre-download dependencies
RUN mvn dependency:go-offline -B

# Now copy the rest of the project
COPY . .
# Build & test
RUN mvn clean test