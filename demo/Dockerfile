# 1. Usamos uma imagem base com Java 17 (versão leve "Alpine")
FROM eclipse-temurin:17-jdk-alpine
# 2. Criamos uma pasta de trabalho dentro do container
WORKDIR /app
# 3. Copiamos todos os arquivos do teu projeto Java (pom.xml, src, etc) para dentro
COPY . .
# 4. Damos permissão para o executável do Maven rodar no Linux do container
RUN chmod +x mvnw
# 5. Compilamos o projeto e geramos o pacote .jar (ignorando testes para ser mais rápido)
RUN ./mvnw clean package -DskipTests
# 6. O comando que roda quando o container inicia
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]