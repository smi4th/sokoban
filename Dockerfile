# a java dockefile that run a basic java program
FROM openjdk:17-jdk-alpine
# set the working directory
WORKDIR /app
# copy the jar file to the container
COPY target/*.jar /app/JavaDocker-0.0.1-SNAPSHOT.jar
# copy the entrypoint.sh file to the container
COPY entrypoint.sh /app/entrypoint.sh
# give execute permission to the entrypoint.sh file
RUN chmod +x /app/entrypoint.sh 
# run the entrypoint.sh file
ENTRYPOINT ["/app/entrypoint.sh"]
# expose the port 8080
EXPOSE 8080
# run the jar file
CMD ["java", "-jar", "/app/JavaDocker-0.0.1-SNAPSHOT.jar"]
