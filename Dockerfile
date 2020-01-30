FROM maven:3.6.3-jdk-8-openj9 AS build
MAINTAINER Vasko <vaskovasilev94@yahoo.com>

RUN mkdir -p /usr/src
RUN mkdir -p /usr/share/maven/ref; mkdir -p /app
WORKDIR /app
COPY pom.xml .
#COPY libs libs
#COPY repo repo
RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY src src
#we explode our app
RUN mvn compile war:exploded
RUN java -version
# the data is in /app/target/Mlpk-1.0-SNAPSHOT/WEB-INF

FROM tomcat:9.0.30-jdk8-openjdk

ENV APP_NAME="Mlpk"
ENV APP_CLASS="com.mlpk"
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"
ENV APP_VERSION="1.0-SNAPSHOT"

WORKDIR /usr/local/tomcat/webapps/ROOT
COPY --from=build /app/target/${APP_NAME}-$APP_VERSION .
COPY ./web .
RUN java -version

CMD ["catalina.sh", "run"]
