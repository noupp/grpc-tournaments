package grpc.tournaments;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ReservationServerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080).addService(new ReservationPlaceGrpcImpl()).build();
        server.start();
        server.awaitTermination();
    }
}
