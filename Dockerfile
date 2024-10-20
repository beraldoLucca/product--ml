FROM openjdk:21-jdk-slim

WORKDIR /app

COPY /target/product-0.0.1-SNAPSHOT.jar /app/product.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/product.jar"]