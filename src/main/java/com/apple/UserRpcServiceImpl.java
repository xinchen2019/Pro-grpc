package com.apple;

import com.apple.dto.MessageProto;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.logging.Logger;

/**
 * @Program: Pro-grpc
 * @ClassName: UserRpcServiceImpl
 * @Description: TODO
 * @Author Mr.Apple
 * @Create: 2021-10-15 15:27
 * @Version 1.1.0
 **/
public class UserRpcServiceImpl extends UserRpcServiceGrpc.UserRpcServiceImplBase {
    private static final Logger logger = Logger.getLogger(UserRpcServiceImpl.class.getName());

    @Override
    public void listByAge(UserRpcProto.AgeRequest request, StreamObserver<UserRpcProto.UserResponse> responseObserver) {
        logger.info("Server Rec listByAge request...");

        // 构造响应，模拟业务逻辑
        UserRpcProto.UserResponse response = UserRpcProto.UserResponse.newBuilder()
                .setCode(0)
                .setMsg("success")
                .addUser(MessageProto.User.newBuilder()
                        .setName(RandomStringUtils.randomAlphabetic(5))
                        .setAge(request.getAge()).build())
                .addUser(MessageProto.User.newBuilder()
                        .setName(RandomStringUtils.randomAlphabetic(5))
                        .setAge(request.getAge()).build())
                .addUser(MessageProto.User.newBuilder()
                        .setName(RandomStringUtils.randomAlphabetic(5))
                        .setAge(request.getAge()).build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
