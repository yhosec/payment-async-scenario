FROM openjdk:11

USER root
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} producer.jar
ENTRYPOINT ["java","-jar","/producer.jar"]