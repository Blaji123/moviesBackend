#
# Build stage
#

ARG MONGO_DATABASE
ARG MONGO_USER
ARG MONGO_PASSWORD
ARG MONGO_CLUSTER

FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR usr/src/app

COPY . ./

RUN mvn clean package -Dmongo.database=${MONGO_DATABASE} -Dmongo.user=${MONGO_USER} -Dmongo.password=${MONGO_PASSWORD} -Dmongo.cluster=${MONGO_CLUSTER}

#
# Package stage
#

FROM eclipse-temurin:21-jdk-alpine

ARG JAR_NAME="movies-0.0.1-SNAPSHOT"

WORKDIR /usr/src/app

COPY --from=build /usr/src/app/target/${JAR_NAME}.jar ./app.jar

CMD ["java","-jar", "./app.jar"]