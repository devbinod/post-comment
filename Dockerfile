FROM maven:3.8.6-amazoncorretto-17 AS builder
WORKDIR /app
COPY . .
RUN mvn install

FROM openjdk:17.0.2-jdk as deploy
MAINTAINER BINOD PANT
WORKDIR /app
COPY --from=builder /app/target/*.jar postcomment.jar
CMD ["java","-jar","postcomment.jar"]