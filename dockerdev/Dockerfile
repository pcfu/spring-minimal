ARG BASE_IMAGE
ARG RELEASE
FROM $BASE_IMAGE:$RELEASE

ARG PROJECT_NAME
ARG JAVA_VERSION

ENV DEBIAN_FRONTEND noninteractive
ENV DEBCONF_NONINTERACTIVE_SEEN true
ENV LANG C.UTF-8

RUN apt update -qq && \
    apt install -yq --no-install-recommends \
      openjdk-$JAVA_VERSION-jre-headless

    # Add user
RUN adduser spring && \
    # Add project directory
    mkdir -p /$PROJECT_NAME && \
    chown -R spring:spring /$PROJECT_NAME && \
    chmod -R 755 /$PROJECT_NAME && \
    # Add gradle directory
    mkdir -p /home/spring/.gradle && \
    chown -R spring:spring /home/spring/.gradle

WORKDIR /$PROJECT_NAME
