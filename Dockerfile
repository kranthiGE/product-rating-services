FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /apps

FROM maven:3.5-jdk-8-alpine
WORKDIR /opt/services/apps/product-rating-services/

ADD pom.xml pom.xml
ADD src src
RUN ["mvn", "package"]

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/apps/product-rating-services/target/product-rating-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 9999