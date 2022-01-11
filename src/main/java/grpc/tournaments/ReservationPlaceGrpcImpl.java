package grpc.tournaments;

import infres.webservices.protos.*;
import io.grpc.stub.StreamObserver;

public class ReservationPlaceGrpcImpl extends ReservationPlaceGrpc.ReservationPlaceImplBase {
    @Override
    public void reservePlace(PlaceRequest request, StreamObserver<PlaceResponse> responseObserver) {
        PlaceResponse response;
        if(request.getIsAvailable()){
            //place dispo : je réserve et la place n'est plus disponible
            response = PlaceResponse.newBuilder().setStatus(true).build();
//            PlaceRequest updatedPlace = PlaceRequest.newBuilder()
//                    .setPlaceType(request.getPlaceType())
//                    .setPrice(request.getPrice())
//                    .setBookingDate(request.getBookingDate())
//                    .setPlaceType(request.getPlaceType())
//                    .setIsAvailable(false)
//                    .build();
//            request = updatedPlace;
        }
        else{
            //place non dispo : je ne peux pas réserver
            response = PlaceResponse.newBuilder().setStatus(false).build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getPlace(PlaceId request, StreamObserver<PlaceRequest> responseObserver) {
        PlaceRequest placeRequest = PlaceRequest.newBuilder()
                .setIsAvailable(false)
                .setPlaceId(request)
                .setBookingDate(Date.newBuilder()
                        .setDay(1)
                        .setMonth(2)
                        .setYear(2000)
                        .setHour(10))
                .setPlaceType(Place.PRIVATE)
                .setPrice(150)
                .build();
        responseObserver.onNext(placeRequest);
        responseObserver.onCompleted();
    }
}
