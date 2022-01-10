package tournaments.grpc;

import infres.webservices.protos.GreeterGrpc;
import infres.webservices.protos.HelloReply;
import infres.webservices.protos.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;

/**
 * Hello world!
 *
 */
public class ClientApp
{
    public static void main( String[] args )
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("Estelle").build());
        System.out.println("Response received from server:\n" + reply);

        channel.shutdown();
    }
}
