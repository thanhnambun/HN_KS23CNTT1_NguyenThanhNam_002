# ========== Stage 1: Build ==========
FROM gradle:8-jdk17 AS builder
WORKDIR /build
COPY . .
RUN gradle build -x test --no-daemon

# ========== Stage 2: Runtime ==========
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /build/build/libs/*.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]
