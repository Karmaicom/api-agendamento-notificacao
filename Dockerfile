FROM eclipse-temurin:21-jdk-jammy

LABEL maintainer="Karmaicom Martins"
LABEL application="api-transacao"
LABEL version="1.0.0"

WORKDIR /app

COPY target/api-agendamento-notificacao-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]