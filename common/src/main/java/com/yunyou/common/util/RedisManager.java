package com.yunyou.common.util;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.io.Serializable;

/**
 * Created by lds on 2017/4/13.
 */
public class RedisManager {
    public static final String HOST="139.199.94.18";
    public static final int PORT=6379;
    public static Jedis reader = new Jedis(HOST,PORT);
    public static Jedis writer = new Jedis(HOST,PORT);
    static {
        //TODO
//        reader.auth("1qazxS");
    }
    public static String setObj(String key,Serializable obj){
        String res = writer.set(key, new Gson().toJson(obj));
        return res;
    }
    public static <T> T getObj(String key,Class<T> clz){
        return new Gson().fromJson(reader.get(key),clz);
    }

    public static void main(String[] args) {
        System.out.println(reader.get("test"));
        writer.set("test","test");
        System.out.println(reader.get("test"));
    }
}
