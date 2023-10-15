FROM amazoncorretto:17.0.2

WORKDIR /app/mcsv-users

COPY ./pom.xml /app
COPY ./mcsv-users .

RUN ./mvnw clean package -DskipTests

EXPOSE 8001

ENTRYPOINT ["java","-jar","./target/mcsv-users-0.0.1-SNAPSHOT.jar"]