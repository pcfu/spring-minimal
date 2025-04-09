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
      inotify-tools \
      lsof \
      wget \
      java-common \
    && rm -rf /var/lib/apt/lists/*

RUN wget --no-check-certificate -P / https://corretto.aws/downloads/latest/amazon-corretto-17-aarch64-linux-jdk.deb && \
    dpkg --install /amazon-corretto-17-aarch64-linux-jdk.deb && \
    rm /amazon-corretto-17-aarch64-linux-jdk.deb

RUN adduser spring && \
    # Add project directory
    mkdir -p /$PROJECT_NAME && \
    chown -R spring:spring /$PROJECT_NAME && \
    chmod -R 755 /$PROJECT_NAME && \
    # Add gradle directory
    mkdir -p /home/spring/.gradle && \
    chown -R spring:spring /home/spring/.gradle

WORKDIR /$PROJECT_NAME
