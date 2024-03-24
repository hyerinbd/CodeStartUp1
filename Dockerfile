FROM openjdk:17-jdk-alpine

RUN gralde

jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

# docker build -t spring-boot-docker .