FROM openjdk:8
VOLUME /tmp
ADD target/JuniorLib-0.0.1-SNAPSHOT.jar junlib.jar
ENTRYPOINT ["java","-jar","junlib.jar"]