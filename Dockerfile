FROM oracle/graalvm-ce:1.0.0-rc13 as graalvm
COPY . /home/app/micronaut-http-client
WORKDIR /home/app/micronaut-http-client
RUN native-image --no-server -cp target/micronaut-http-client-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-http-client .
ENTRYPOINT ["./micronaut-http-client"]
