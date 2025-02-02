# Base Image com Java 21
FROM eclipse-temurin:21-jdk

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR para dentro do container
COPY target/taskmanagerapi-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
