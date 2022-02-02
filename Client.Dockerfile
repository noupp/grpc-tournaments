FROM openjdk:latest
#workdir = container work directory
WORKDIR /usr/src/myapp
COPY target/InfresGrpcWebService-1.0-jar-with-dependencies.jar .
COPY target/InfresGrpcWebService-1.0.jar .
EXPOSE 8080
CMD java -cp "InfresGrpcWebService-1.0-jar-with-dependencies.jar:InfresGrpcWebService-1.0.jar" grpc.tournaments.ReservationClientApp
#docker inspect my-grpc-server -> look up ip address of server container
#change channel ip address in Client class to server address and rebuild project
#docker build -f Client.Dockerfile -t my-grpc-client .
#docker run -it --rm --name my-grpc-client my-grpc-client