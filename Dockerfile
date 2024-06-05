# FROM alpine/git as clone

# WORKDIR /tmp

# RUN git clone https://github.com/GoogleCloudPlatform/opentelemetry-operations-java.git


# FROM eclipse-temurin:11-focal as cloud-trace-builder

# COPY --from=clone /tmp/opentelemetry-operations-java /tmp/opentelemetry-operations-java

# WORKDIR /tmp/opentelemetry-operations-java

# RUN ./gradlew clean :exporter-auto:shadowJar

# WORKDIR /tmp/opentelemetry-operations-java/exporters/auto/build/libs

# RUN for file in *.jar; do mv $file /tmp/exporter-auto.jar; done


FROM eclipse-temurin

ARG TARGET_JAR=turtle-0.0.1-SNAPSHOT.jar
ENV TARGET_JAR=$TARGET_JAR

COPY /build/libs/${TARGET_JAR} /app/

WORKDIR /app

# RUN curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

# COPY --from=cloud-trace-builder /tmp/exporter-auto.jar /app/

EXPOSE 8080

ENTRYPOINT java -jar /app/${TARGET_JAR}