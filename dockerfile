# Use lightweight JDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy fat JAR and testng.xml
COPY target/selenium-testng-project-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
COPY testng.xml .

# Run TestNG using the suite XML
CMD ["java", "-cp", "app.jar", "org.testng.TestNG", "testng.xml"]
