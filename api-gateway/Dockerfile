# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim
EXPOSE 8081
ADD target/api-gateway.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
# Run the JAR file



