FROM openjdk:latest
#workdir = container work directory
WORKDIR /usr/src/myapp
COPY target/InfresGrpcWebService-1.0-jar-with-dependencies.jar .
COPY target/InfresGrpcWebService-1.0.jar .
EXPOSE 8080
CMD java -cp "InfresGrpcWebService-1.0-jar-with-dependencies.jar:InfresGrpcWebService-1.0.jar" grpc.tournaments.ReservationServerApp
#docker build -f Server.Dockerfile -t my-grpc-server .
#docker run -p 8080:8080 -it --rm --name my-grpc-server my-grpc-server