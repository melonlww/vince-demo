package com.xima.util;

public class Utils {

    public static void println(Object message) {
        System.out.printf("[Thread : %s]: %s \n", Thread.currentThread().getName(), String.valueOf(message));
    }
}
