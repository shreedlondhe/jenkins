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

# use below command to run project
#    docker run --rm -v "%USERPROFILE%\.m2:/root/.m2" -v "%cd%:/app" -v "%cd%\allure-results:/app/target/allure-results" -w /app selenium-test:latest

