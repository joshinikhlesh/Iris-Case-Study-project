FROM openjdk:17-jdk-slim
EXPOSE 8087
ADD target/card-validation-service.jar card-validation-service.jar
ENTRYPOINT ["java", "-jar", "card-validation-service.jar"]
# Run the JAR file

