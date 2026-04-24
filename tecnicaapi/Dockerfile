FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/tecnicaapi-0.0.1.jar
COPY ${JAR_FILE} app_pruebatecnica.jar
EXPOSE 8080
ENTRYPOINT["java", "-jar", "app_pruebatecnica.jar"]