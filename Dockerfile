FROM openjdk:11
#RUN addgroup -S devdocker && adduser -S vittoria -G devdocker
#USER vittoria:devdocker

ARG JAR_FILE=target/*.jar
VOLUME /tmp
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]