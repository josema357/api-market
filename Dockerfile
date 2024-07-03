FROM amazoncorretto:17-alpine-jdk

COPY build/libs/market-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]