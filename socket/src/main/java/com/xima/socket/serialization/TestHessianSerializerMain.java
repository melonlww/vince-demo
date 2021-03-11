package com.xima.socket.serialization;

import com.xima.socket.serialization.domain.User;
import com.xima.socket.serialization.service.ISerializer;
import com.xima.socket.serialization.service.impl.HessianSerializer;

//bytes.length = 70
public class TestHessianSerializerMain {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Mic");
        user.setAge(5);

        ISerializer serializer = new HessianSerializer();
        byte[] bytes = serializer.serialize(user);
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]+ " ");
        }
        System.out.println();

        User deserializeUser = serializer.deserialize(bytes);
        System.out.println(deserializeUser);
    }
}
