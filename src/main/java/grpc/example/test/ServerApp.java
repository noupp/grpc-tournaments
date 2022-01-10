package grpc.example.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080).addService(new GreeterServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
