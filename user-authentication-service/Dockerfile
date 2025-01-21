FROM openjdk:17-jdk-slim
EXPOSE 8082
ADD target/user-authentication-service.jar user-authentication-service.jar
ENTRYPOINT ["java", "-jar", "user-authentication-service.jar"]
