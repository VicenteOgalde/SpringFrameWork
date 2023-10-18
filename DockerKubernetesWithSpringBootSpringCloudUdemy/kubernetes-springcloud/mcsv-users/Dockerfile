FROM amazoncorretto:17-alpine-jdk as builder

WORKDIR /app/mcsv-users

COPY ./pom.xml /app
COPY ./mcsv-users/.mvn ./.mvn
COPY ./mcsv-users/mvnw .
COPY ./mcsv-users/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./mcsv-users/src ./src

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk

EXPOSE 8001

ENTRYPOINT ["java","-jar","./target/mcsv-users-0.0.1-SNAPSHOT.jar"]