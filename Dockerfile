#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8080
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY . .

# Remove the target directory
RUN rm -rf target

# Run Maven to package the application
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/HoTroTinhThue-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]