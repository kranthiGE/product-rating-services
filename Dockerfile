FROM openjdk:8-jdk-alpine
MAINTAINER kranthikirana
VOLUME /tmp
COPY /target/product-rating-services-0.0.1-SNAPSHOT.jar /opt/services/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/services/lib/product-rating-services-0.0.1-SNAPSHOT.jar"]
EXPOSE 9999