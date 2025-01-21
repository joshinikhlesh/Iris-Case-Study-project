FROM openjdk:17-jdk-slim
EXPOSE 8086
ADD target/payment-service.jar payment-service.jar
ENTRYPOINT ["java", "-jar", "payment-service.jar"]
# Run the JAR file
