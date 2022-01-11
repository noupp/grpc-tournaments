package grpc.tournaments;

import com.google.protobuf.Descriptors;
import infres.webservices.protos.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ReservationClientApp {
    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        ReservationPlaceGrpc.ReservationPlaceBlockingStub stub = ReservationPlaceGrpc.newBlockingStub(channel);
        PlaceRequest request = stub.getPlace(PlaceId.newBuilder().setPlaceId(50).build());
        PlaceResponse response = stub.reservePlace(request);
        System.out.println("Place num.:" + request.getPlaceId().getPlaceId());
        System.out.println("Place type:" + request.getPlaceType().name());
        System.out.println("Place date:\n" + request.getBookingDate());
        System.out.println("Place available: " + request.getIsAvailable());
        System.out.println("Place booked " + response);

        channel.shutdown();
    }
}
