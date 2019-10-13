package com.ssj.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest01 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("192.168.71.101",6379);
		//测试连接
		System.out.println(jedis.ping());
		
	}
}
