FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY build/libs/yourvietnam-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#docker build --build-arg JAR_FILE=build/libs/*.jar -t yourvn .
#docker build -t tamlt2704/yourvn .