# docker build --build-arg APP_NAME=product-rating-services --build-arg APP_VERSION=0.0.1-SNAPSHOT --build-arg ENV=dev --tag=product-rating-services:v1.0 .
############ BUILD STEP ##############
FROM maven:3.6.0-jdk-8-alpine AS BUILD
MAINTAINER kranthikirana

# WORKDIR apps/product-rating-services/
WORKDIR /usr/local/app
COPY . .

ARG ENV=${ENV:-dev}
ENV ENV=${ENV:-dev}

COPY application-${ENV}.properties /usr/local/app/src/main/resources/application.properties

RUN echo "Environment was set to: $ENV" 

ADD settings-mvn.xml settings-mvn.xml
# RUN ["mvn", "-s", "settings-mvn.xml", "clean", "install"]
# RUN mvn clean && mvn install

############ RUN STEP #############
FROM openjdk:8-jre-slim

ARG APP_NAME
ARG APP_VERSION

ENV APP_NAME=${APP_NAME} \
    APP_VERSION=${APP_VERSION}

COPY --from=BUILD /usr/local/app/target/${APP_NAME}-${APP_VERSION}.jar /usr/local

WORKDIR /usr/local
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java"]
CMD java -jar ${APP_NAME}-${APP_VERSION}.jar
