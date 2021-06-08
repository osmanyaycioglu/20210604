FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-discovery-1.0.0.jar xyz.jar
ENV TEST_ENV=5555
ENTRYPOINT [ "sh","-c","java -DASDF=${TEST_ENV} -jar xyz.jar" ]
