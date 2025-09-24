# Use Maven + JDK + Chrome image
FROM markhobson/maven-chrome:jdk-21

# Set working directory inside container
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src
COPY testng.xml .

# Download dependencies (so they are cached in Docker image)
RUN mvn dependency:resolve

# Run TestNG tests
CMD ["mvn", "clean", "test"]
