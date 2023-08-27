FROM openjdk
COPY build/libs/demo-sec-0.0.1-SNAPSHOT.jar demo.jar

ENTRYPOINT ["java", "-jar","/demo.jar"]