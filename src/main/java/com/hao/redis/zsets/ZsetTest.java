package com.hao.redis.zsets;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <code>ZsetTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/5
 * @version: 1.0
 */
public class ZsetTest {
    public static void main(String[] args) {
        String key = "mostUsedLanguages";
        Jedis jedis = new Jedis("127.0.0.1");
        //Adding a value with score to the set
        jedis.zadd(key,100,"Java");//ZADD

        //We could add more than one value in one calling
        Map<String, Double> scoreMembers = new HashMap<String, Double>();
        scoreMembers.put("Python",90d);
        scoreMembers.put("Javascript",80d);
        jedis.zadd(key, scoreMembers);

        //We could get the score for a member
        System.out.println("Number of Java users:" + jedis.zscore(key, "Java"));

        //We could get the number of elements on the set
        System.out.println("Number of elements:" + jedis.zcard(key));//ZCARD


        //get all the elements sorted from bottom to top
        System.out.println(jedis.zrange(key, 0, -1));

        //get all the elements sorted from top to bottom
        System.out.println(jedis.zrevrange(key, 0, -1));
        //We could get the elements with the associated score
        Set<Tuple> elements = jedis.zrevrangeWithScores(key, 0, -1);
        for(Tuple tuple: elements){
            System.out.println(tuple.getElement() + "-" + tuple.getScore());
        }

        //We can increment a score for a element using ZINCRBY
        System.out.println("Score before zincrby:" + jedis.zscore(key, "Python"));
        //Incrementing the element score
        jedis.zincrby(key, 1, "Python");
        System.out.println("Score after zincrby:" + jedis.zscore(key, "Python"));
    }
}
