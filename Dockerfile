FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw mvnw.cmd pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

RUN rm /app/target/*.jar.original

FROM eclipse-temurin:17-jre-jammy as final

WORKDIR /app

COPY --from=build /app/target/*.jar /app/project.jar

EXPOSE 8080

ENTRYPOINT [ "java" , "-jar" , "/app/project.jar" ]
