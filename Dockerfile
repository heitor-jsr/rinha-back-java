# Build stage
FROM ghcr.io/graalvm/native-image-community:21 as build
WORKDIR /rinha-backend-2024-q1
COPY --chown=1000:1000 --chmod=755 . /rinha-backend-2024-q1

RUN ./mvnw -Pnative native:compile

# Run stage
FROM alpine
COPY --from=build /rinha-backend-2024-q1/target/rinha-backend-2024-q1 /rinha-backend-2024-q1
RUN apk add libc6-compat curl
EXPOSE 8080
CMD ["/rinha-backend-2024-q1"]
