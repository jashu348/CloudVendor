# Use a lightweight OpenJDK image as the base
FROM openjdk:17-jdk-alpine

# Metadata (optional)
LABEL author="your-name"

# Set the working directory inside the image
WORKDIR /app

# Copy the built JAR file from the host into the image
COPY target/*.jar app.jar

# Command to run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
