FROM openjdk

VOLUME /tmp
ADD maven/explorando-marte-0.0.1-SNAPSHOT.jar explorando-marte-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /explorando-marte-0.0.1-SNAPSHOT'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/explorando-marte-0.0.1-SNAPSHOT.jar"]