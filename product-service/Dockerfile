FROM openjdk:17-jdk-slim
EXPOSE 8084
ADD target/product-service.jar product-service.jar
ENTRYPOINT ["java", "-jar", "product-service.jar"]
