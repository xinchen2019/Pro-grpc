package com.apple.utils;

import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;

/**
 * @Program: Pro-grpc
 * @ClassName: ProtoUtils
 * @Description: TODO
 * @Author Mr.Apple
 * @Create: 2021-10-15 15:30
 * @Version 1.1.0
 **/
public class ProtoUtils {
    private static JsonFormat JSON_FORMAT;
    static {
        JSON_FORMAT = new JsonFormat();
    }
    public static String toStr(Message message) {
        return JSON_FORMAT.printToString(message);
    }
}
