FROM openjdk:17-jdk-slim
EXPOSE 8088
ADD target/config-server.jar config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]
# Run the JAR file

