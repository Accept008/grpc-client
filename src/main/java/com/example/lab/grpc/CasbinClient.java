package com.example.lab.grpc;

import io.grpc.examples.proto.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class CasbinClient {

    @GrpcClient("local-grpc-server")
    private CasbinGrpc.CasbinBlockingStub casbinBlockingStub;

    private void init(){
        NewAdapterReply newAdapterReply = casbinBlockingStub.newAdapter(NewAdapterRequest.newBuilder().build());
        NewEnforcerReply newEnforcerReply = casbinBlockingStub.newEnforcer(NewEnforcerRequest.newBuilder().build());
    }

    /**
     * Enforce()
     * @param enforceRequest
     * @return
     * @throws Exception
     */
    public boolean enforce(EnforceRequest enforceRequest) throws Exception{
        init();

        BoolReply boolReply = casbinBlockingStub.enforce(enforceRequest);
        return boolReply.getRes();
    }
}
