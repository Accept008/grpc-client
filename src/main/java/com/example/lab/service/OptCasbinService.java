package com.example.lab.service;

import com.example.lab.grpc.CasbinClient;
import io.grpc.examples.proto.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptCasbinService {
    @Autowired
    CasbinClient casbinClient;

    @GrpcClient("local-grpc-server")
    private CasbinGrpc.CasbinBlockingStub casbinBlockingStub;

    private void init(){
        NewAdapterReply newAdapterReply = casbinBlockingStub.newAdapter(NewAdapterRequest.newBuilder().build());
        NewEnforcerReply newEnforcerReply = casbinBlockingStub.newEnforcer(NewEnforcerRequest.newBuilder().build());
    }

    public Object getAllSubjects(){
        init();
        ArrayReply arrayReply = casbinBlockingStub.getAllSubjects(EmptyRequest.newBuilder().build());
        System.out.println("arrayReply.getArrayList() -> "+ arrayReply.getArrayList());
        return arrayReply.getArrayList();
    }

    public Object getPolicy(){
        init();
        Array2DReply array2DReply = casbinBlockingStub.getPolicy(EmptyRequest.newBuilder().build());
        System.out.println("array2DReply.getD2List() -> "+array2DReply.getD2List());
        return array2DReply.getD2List().toString();
    }


    /**
     *  是否存在命名授权规则
     *   hasNamedPolicy := e.HasNamedPolicy("p", "data2_admin", "data2", "read")
     * @return
     */
    public Object hasNamedPolicy() {
        return null;
    }

    public Object enforce() {
        init();

        List<String> params = new ArrayList<>();
        params.add("alice");
        params.add("data1");
        params.add("read1");

        EnforceRequest enforceRequest = EnforceRequest.newBuilder()
                                        .addAllParams(params)
                                        .build();
        BoolReply boolReply = casbinBlockingStub.enforce(enforceRequest);
        return boolReply.getRes();
    }
}


//rpc NewEnforcer (NewEnforcerRequest) returns (NewEnforcerReply) {}
//rpc NewAdapter (NewAdapterRequest) returns (NewAdapterReply) {}
//
//rpc Enforce (EnforceRequest) returns (BoolReply) {}
//
//rpc LoadPolicy (EmptyRequest) returns (EmptyReply) {}