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
 - docker stop <containerId>
## Running on a EC2 (RHEL v1.0)
 - Install the following
 `
  - sudo yum update
  - sudo yum install docker
  - sudo yum install -y git
  - sudo yum groupinstall -y 'Development Tools'
  - sudo service docker start
  - sudo user -a -G docker $USER
 `
## Pushing images to ECR
 `
  [ec2-user@ip-172-31-5-164 ~]$ docker tag product-rating-services 094592729622.dkr.ecr.ap-south-1.amazonaws.com/product-rating-services
  [ec2-user@ip-172-31-5-164 ~]$ docker tag spring-product-services 094592729622.dkr.ecr.ap-south-1.amazonaws.com/spring-product-services
 `
## Install ECS agent
  - Copy below content into bootup script text creation during EC2 instance creation.
    demo-cluster is the name of the cluster the ECS agent is going to integrate with
  `
    #!/bin/bash
    mkdir -p /etc/ecs
    touch /etc/ecs/ecs.config
    echo ECS_CLUSTER=demo-cluster >> /etc/ecs/ecs.config
  `
  - login to EC2 instance
  - install docker
  `
    sudo yum update -y
    sudo yum install docker -y
    sudo service docker start
  `
  - Allow EC2 instance to have access to docker deamon
  `
    sudo usermod -a -G docker $USER
  `
  - Install ECS agent and start. Install docker and start the docker process before running ecs agent
  `
    sudo yum install ecs-init
    sudo start ecs
  `

## Creating task definition
 - Create task definition files
 - And using aws ecs cli, register the tasks
 `
 aws ecs register-task-definition --cli-input-json file://task-definition.json
 `
 ## Create a stopped docker container
 `
  docker create <<imageId>>

  docker ps -a //to view the container id

  docker insepect <<containerId>> // to view the details inside the container

  docker cp a0cf69d86d04:/usr/local/app .
 `
 ## Debug inside the container
`
docker exec -it feed bash
`

URL:
	-

References:
=======
