FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

# Copia o JAR construído para o diretório de trabalho
COPY build/libs/experimentacoes-kotlin-0.0.1-SNAPSHOT.jar /app/experimentacoes-kotlin.jar

EXPOSE 8080

# Executa o JAR
CMD ["java", "-jar", "/app/experimentacoes-kotlin.jar"]
