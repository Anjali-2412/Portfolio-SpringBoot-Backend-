# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy all source code
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot application
CMD ["java", "-jar", "target/*.jar"]
