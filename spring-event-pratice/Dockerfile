FROM openjdk:17.0
COPY target/spring-event-pratice-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 18080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]