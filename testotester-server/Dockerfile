FROM openjdk:17-jdk-alpine
WORKDIR tt-server/app
ARG JAR_FILE=target/*.jar
VOLUME /tmp
COPY ${JAR_FILE} app.jar
ENTRYPOINT java -jar app.jar
