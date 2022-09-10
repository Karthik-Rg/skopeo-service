FROM alpine:edge

RUN apk add openjdk11
RUN apk update
RUN apk add curl skopeo

RUN apk info -vv

ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=0.0.0.0:8081,server=y,suspend=n

EXPOSE 8080

EXPOSE 8081

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]