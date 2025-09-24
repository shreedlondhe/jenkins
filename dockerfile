# Use Maven + JDK + Chrome image
FROM markhobson/maven-chrome:jdk-21

# Set working directory inside container
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src
COPY testng.xml .

# Download dependencies
RUN mvn dependency:resolve

# Run TestNG tests and generate Allure results
# Assuming allure-testng adapter is added in pom.xml
CMD ["mvn", "clean", "test", "allure:report"]
