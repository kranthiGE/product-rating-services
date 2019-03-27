## Sample product-rating-service microservice
=========================
Author: Kranthi Kiran
Created on: 17-Nov-16
Description: Sample project that provides RESTful APIs on products shopstore

#Features:
- Springboot product rating catalog API sample
- API Exception handling
- Java 8 Stream API samples 

#Installing & local setup:
 - docker build --file=Dockerfile \--tag=product-rating-services:latest --rm=true .
 - docker run -p 9999:8080 -t product-rating-services:latest
 - Commands to push to docker hub
 	- docker images
 	- docker tag 79b782d7ef96 kranthikirana@product-rating-services:latest
 	- docker push kranthikirana/product-rating-services:latest
URL: 

References:
=======

