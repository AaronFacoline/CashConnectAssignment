ARG BUILD_HOME=/CashConnectAssignment

FROM gradle:jdk25-corretto AS build-image
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME
COPY --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src
RUN gradle --no-daemon build

FROM amazoncorretto:25
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
COPY --from=build-image $APP_HOME/build/libs/CashConnectAssignment-0.0.1.jar /usr/app/CashConnectAssignment.jar
WORKDIR /usr/app
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "CashConnectAssignment.jar"]