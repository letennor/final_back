package com.final_back.utils.common;

import com.final_back.entity.system.UserBasicInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtil {


    public static Map<String, UserBasicInfo> tokenMap = new HashMap<>();


    public static String generateToken(UserBasicInfo user) {
        //生成唯一不重复的字符串
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, user);
        return token;
    }

    /**
     * 验证token是否合法
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        return tokenMap.containsKey(token);
    }

    public static UserBasicInfo getUser(String token) {
        return tokenMap.get(token);
    }

    public static void removeUser(String token) {
        tokenMap.remove(token);
        return;
    }

}