FROM openjdk:8-jdk-alpine
RUN addgroup -S devdocker && adduser -S vittoria -G devdocker
USER vittoria:devdocker

ARG JAR_FILE=target/*.jar
VOLUME /tmp
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]