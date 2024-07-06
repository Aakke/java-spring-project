@ECHO OFF
ECHO Cleaning the package, building dockerFiles and starting the application via Docker-compose

call mvnw clean package -DskipTests

docker build --tag=spring-project:latest .

docker-compose up
