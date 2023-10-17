FROM amazoncorretto:17.0.2

WORKDIR /app/mcsv-users

COPY ./pom.xml /app
COPY ./mcsv-users/.mvn ./.mvn
COPY ./mcsv-users/mvnw .
COPY ./mcsv-users/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./mcsv-users/src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8001

ENTRYPOINT ["java","-jar","./target/mcsv-users-0.0.1-SNAPSHOT.jar"]