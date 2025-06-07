FROM amazoncorretto:17-alpine-jdk
MAINTAINER ESMERALDA
COPY MiComedor/target/MiComedor-0.0.1-SNAPSHOT.jar MiComedorBackend.jar
ENTRYPOINT ["java", "-jar", "/MiComedorBackend.jar"]
