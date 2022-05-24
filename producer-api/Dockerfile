FROM openjdk:17-jdk-alpine as build
WORKDIR /workspace/app
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY src src
RUN ls
RUN ./gradlew clean build -x test --parallel
RUN ls build/libs
RUN mkdir -p build/dependency && \
    cd build/dependency && \
    jar -xf ../libs/app-0.0.1-SNAPSHOT.jar
FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","br.com.bixb.producerapi.Application"]