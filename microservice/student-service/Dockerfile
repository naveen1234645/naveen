FROM openjdk:latest
EXPOSE 8081
ADD target/employee-service.jar employee-service.jar
ENTRYPOINT ["sh", "-c", "java -jar /employee-service.jar"]