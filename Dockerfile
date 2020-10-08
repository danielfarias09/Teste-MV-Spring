  
#Imagem base usada para criar a minha imagem
FROM openjdk:8-jdk-alpine

#Define uma variável para ser utilizada no momento do build (nome definido no finalName do pom)
ARG JAR_FILE=target/cadastro-profissional.jar

#Copia o cadastro-profissional.jar para app.jar
COPY ${JAR_FILE} app.jar

#Ensina o docker como executar a aplicação java
ENTRYPOINT ["java","-jar","/app.jar"]

#Apenas para fins de documentação. Este comando diz em que porta a aplicação está escutando
EXPOSE 8080