FROM gradle:7-jdk16 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:16
ENV PORT="8080"
RUN mkdir /app
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/com.github.SebPasieka.weltCrawler.jar
ENTRYPOINT ["java", "-jar", "com.github.SebPasieka.weltCrawler.jar"]


