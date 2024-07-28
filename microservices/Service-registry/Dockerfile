FROM openjdk:latest
EXPOSE 8761
ADD target/ServiceRegistry.jar ServiceRegistry.jar
ENTRYPOINT [ "java", "-jar", "/ServiceRegistry.jar" ]