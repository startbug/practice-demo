FROM openjdk:17.0
COPY target/spring-event-practice-0.0.1-SNAPSHOT.jar /usr/app/app.jar
WORKDIR /usr/app
EXPOSE 18080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]