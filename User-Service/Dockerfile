FROM openjdk:17-jdk-slim
EXPOSE 8083
ADD target/user-service.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
# Run the JAR file

