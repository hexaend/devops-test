FROM gradle:8.14.2-jdk24 AS build

WORKDIR /home/gradle/project

COPY build.gradle.kts settings.gradle.kts gradle.properties ./

COPY src ./src

RUN --mount=type=cache,target=/home/gradle/.gradle/caches \
    --mount=type=cache,target=/home/gradle/.gradle/wrapper \
    gradle bootJar --no-daemon --info

FROM eclipse-temurin:24-jre

WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]