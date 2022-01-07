FROM maven:3.8.1-jdk-11-slim AS MAVEN_BUILD

COPY pom.xml /build
COPY src /build/src

WORKDIR /build
RUN mvn package
FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/sportclub-0.0.1-SNAPSHOT.jar /app/

#ENTRYPOINT ["java","-jar", "sportclub-0.0.1-SNAPSHOT.jar"]
CMD [ "sh", "-c", "java -Xmx280m -jar sportclub-0.0.1-SNAPSHOT.jar"]