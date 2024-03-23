ARG BASE_IMAGE
ARG JAVA_VERSION
ARG LINUX_DISTRO
FROM $BASE_IMAGE:$JAVA_VERSION-$LINUX_DISTRO

ARG PROJECT_NAME

RUN apk update && \
    apk add \
      shadow \
      su-exec \
      bash

    # Add user
RUN adduser -D spring && \
    # Add project directory
    mkdir -p /$PROJECT_NAME && \
    chown -R spring:spring /$PROJECT_NAME && \
    chmod -R 755 /$PROJECT_NAME && \
    # Add gradle directory
    mkdir -p /home/spring/.gradle && \
    chown -R spring:spring /home/spring

WORKDIR /$PROJECT_NAME
