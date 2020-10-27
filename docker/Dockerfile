# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Copy war file
COPY projeto-0.0.1-SNAPSHOT.jar /projeto.war

# run the app
CMD ["/usr/bin/java", "-jar", "/projeto.war"]
