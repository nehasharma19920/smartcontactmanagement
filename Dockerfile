FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/smartcontactmanager-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} smartcontactmanager-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/smartcontactmanager-0.0.1-SNAPSHOT.jar"]