## 어떤 image를 사용할 것인가
#FROM openjdk:17-jdk-alpine
## jar 파일로 만들어라
#ARG JAR_FILE=build/libs/*.jar
## 실행
#COPY ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar
#
#ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]

# 멀티스테이징 빌드
FROM  eclipse-temurin:17-jdk-jammy as builder

COPY . /app
WORKDIR /app

RUN ./gradlew clean -x test build


FROM eclipse-temurin:17-jre-jammy as runner

COPY --from=builder /app/build/libs/codestartup-1.0.jar /app/app.jar

EXPOSE 8080/tcp

# CMD vs ENTRYPOINT
# 1) CMD override, ENTRYPOINT도 override가 안되는 건 아님, 근데 의도적으로 해야함
# 2) PID = process id
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=sandbox", "/app/app.jar"]