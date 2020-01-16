package com.hao.redis;

import redis.clients.jedis.Jedis;


public class RedisTest {
	private void func1(){
		Jedis jedis = new Jedis("localhost");
		System.out.println("DBHelper to server sucessfully");
		System.out.println("Server is running:"+jedis.ping());
		System.out.println("Stored Stirng in redis:"+jedis.get("myKey"));
	}
	private void func2(){
		Jedis jedis = new Jedis("localhost");
		String str1 = jedis.set("token", "abcedfg");
		System.out.println("str1:" + str1);
		String str2 = jedis.get("token");
		System.out.println("str2:"+str2);
		Long lg1 = jedis.expire("token", 10);
		System.out.println("lg1:"+lg1);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String str3 = jedis.get("token");
		System.out.println("str3:"+str3);
	}
	public static void main(String[] args) {
		RedisTest test = new RedisTest();
		test.func2();
	}
}
