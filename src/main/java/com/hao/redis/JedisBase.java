package com.hao.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * <code>JedisBase</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/7
 * @version: 1.0
 */
public class JedisBase {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        System.out.println("DBHelper to server successfully");
        System.out.println("Server is running:" + jedis.ping());
        List<String> list = jedis.lrange("w3ckey",0,-1);
        for(String s : list){
            System.out.println(s);
        }
        if(!jedis.exists("phones")){
            System.out.println("create phones");
            jedis.lpush("phones","18684935455");
            jedis.lpush("phones","15011085031");
        }
    }
}
