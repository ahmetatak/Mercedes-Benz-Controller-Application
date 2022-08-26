FROM openjdk:8-jdk-alpine
MAINTAINER localhost
COPY target/mercedes-benz-controller.jar mercedes-benz-controller.jar
ENTRYPOINT ["java","-jar","/mercedes-benz-controller.jar"]

