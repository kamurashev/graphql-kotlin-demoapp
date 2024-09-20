# Use an official Eclipse Temurin 21 JRE headless image as the base image
FROM eclipse-temurin:21-jre-headless

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container at /app/app.jar
COPY build/libs/*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]