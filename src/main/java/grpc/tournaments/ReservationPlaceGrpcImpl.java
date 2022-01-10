package grpc.tournaments;

import infres.webservices.protos.PlaceId;
import infres.webservices.protos.PlaceRequest;
import infres.webservices.protos.PlaceResponse;
import infres.webservices.protos.ReservationPlaceGrpc;
import io.grpc.stub.StreamObserver;

public class ReservationPlaceGrpcImpl extends ReservationPlaceGrpc.ReservationPlaceImplBase {
    @Override
    public void reservePlace(PlaceRequest request, StreamObserver<PlaceResponse> responseObserver) {
        PlaceResponse response = PlaceResponse.newBuilder().setStatus(request.getIsAvailable()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getPlace(PlaceId request, StreamObserver<PlaceRequest> responseObserver) {
        PlaceRequest placeRequest = PlaceRequest.newBuilder().getDefaultInstanceForType();
    }
}
