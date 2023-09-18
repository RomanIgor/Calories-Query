# Use an official OpenJDK runtime as a parent image
FROM openjdk:20-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container at the specified path
COPY target/calories-0.0.1-SNAPSHOT.jar /app/calories-query.jar

# Expose the port the application will listen on
EXPOSE 8080

# Run the JAR file when the container starts
CMD ["java", "-jar", "calories-query.jar"]
