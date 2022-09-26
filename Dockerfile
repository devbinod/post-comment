FROM maven:latest as builder
WORKDIR /build
COPY . .
RUN mvn clean install -DskipTests


FROM openjdk:17.0.2-jdk as deploy
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
