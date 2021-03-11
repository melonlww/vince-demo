package com.xima.socket.serialization.service;

public interface ISerializer {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data);
}
