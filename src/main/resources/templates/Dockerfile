FROM alpine:edge

RUN apk add --no-cache openjdk11
RUN apk update
RUN apk add skopeo

RUN apk info -vv

COPY skopeo-service-0.0.1.jar skopeo-service-0.0.1.jar

EXPOSE 8001

ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:transport=dt_socket,address=8001,server=y", "-jar", "skopeo-service-0.0.1.jar"]