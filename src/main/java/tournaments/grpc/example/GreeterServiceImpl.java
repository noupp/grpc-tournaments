package tournaments.grpc.example;

import infres.webservices.protos.GreeterGrpc;
import infres.webservices.protos.HelloReply;
import infres.webservices.protos.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
//        super.sayHello(request, responseObserver);
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
