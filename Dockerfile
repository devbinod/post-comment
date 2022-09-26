FROM openjdk:17.0.2-jdk as deploy
MAINTAINER BINOD PANT
WORKDIR /app
COPY  /target/*.jar postcomment.jar
CMD ["java","-jar","postcomment.jar"]