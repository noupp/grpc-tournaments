package grpc.tournaments;

import infres.webservices.protos.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ReservationClientApp {
    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        ReservationPlaceGrpc.ReservationPlaceBlockingStub stub = ReservationPlaceGrpc.newBlockingStub(channel);

        PlaceResponse response = stub.reservePlace(PlaceRequest.newBuilder().build());
        System.out.println("Response received from server:\n" + response);

        channel.shutdown();
    }
}
