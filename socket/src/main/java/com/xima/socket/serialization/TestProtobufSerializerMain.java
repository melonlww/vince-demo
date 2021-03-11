package com.xima.socket.serialization;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xima.socket.serialization.domain.proto.UserProto;

/**
 * {@link UserProto} protobuf domain通过命令生成
 */
//bytes.length = 7
public class TestProtobufSerializerMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        UserProto.User user = UserProto.User.newBuilder().setName("Mic").setAge(5).build();
        ByteString bytes = user.toByteString();
        System.out.println(bytes.size());

        UserProto.User userRever = UserProto.User.parseFrom(bytes);
        System.out.println(userRever);
    }
}
