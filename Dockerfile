FROM openjdk:17-jdk-slim

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven


WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

CMD ["java","-jar","target/todolist-0.0.1-SNAPSHOT.jar" ]