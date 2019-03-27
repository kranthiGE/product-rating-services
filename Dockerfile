FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /apps

FROM maven:3.5-jdk-8-alpine
WORKDIR /apps/product-rating-services
RUN mvn install

COPY /target/product-rating-services-0.0.1-SNAPSHOT.jar /opt/services/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/product-rating-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 9999