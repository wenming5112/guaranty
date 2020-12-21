package com.example.guaranty.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.guaranty.entity.User;

import java.util.*;

/**
 * ByteUtils
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/30 16:24
 **/
public class ByteUtils {

    public static String bytesToString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return JSON.parseObject(JSON.parse(bytes) == null ? null : Objects.requireNonNull(JSON.parse(bytes)).toString()) == null ? null : JSON.parseObject(Objects.requireNonNull(JSON.parse(bytes)).toString()).toString();
    }

    public static <T> byte[] objToBytes(T t) {
        return JSON.toJSONBytes(t);
    }

    private static JSONObject bytesToJson(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return JSON.parseObject(JSON.parse(bytes) == null ? null : Objects.requireNonNull(JSON.parse(bytes)).toString());
    }

    public static <T> JSONObject objToJson(T t) {
        return bytesToJson(objToBytes(t));
    }

    public static <T> T bytesToObj(byte[] bytes, Class<T> t) {
        return JSON.toJavaObject(bytesToJson(bytes), t);
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<>(String::compareTo);
        sortMap.putAll(map);
        return sortMap;
    }

    public static <T> byte[] listToBytes(List<T> t) {
        return JSON.toJSONString(t).getBytes();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("jesus");
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("jesus1");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        byte[] bytes = JSON.toJSONString(users).getBytes();

        List<User> userList = JSONArray.parseArray(new String(bytes), User.class);
        for (User user2 : userList) {
            System.out.println(user2);
        }
    }

}
