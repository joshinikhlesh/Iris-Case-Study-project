FROM openjdk:17-jdk-slim
EXPOSE 8085
ADD target/order-service.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]
# Run the JAR file

