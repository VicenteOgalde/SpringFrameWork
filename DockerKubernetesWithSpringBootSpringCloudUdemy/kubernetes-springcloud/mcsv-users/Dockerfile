FROM amazoncorretto:17.0.2

WORKDIR /app

COPY ./target/mcsv-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java","-jar","mcsv-users-0.0.1-SNAPSHOT.jar"]