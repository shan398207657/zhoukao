package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.ssj.bean.Goods;
@SuppressWarnings("all")
public class Add extends ShanshijiApplicationTests{
	@Resource
	private RedisTemplate redisTemplate;
	
	@Test
	public void addgoods() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("D:\\日考平台\\55e66ff37f2a4738867d37954fe973d5\\add.txt"));
		
		String emp=null;
		while((emp=reader.readLine())!=null) {
			String[] split = emp.split("==");
			Goods good = new Goods();
			System.out.println(split.toString());
			good.setId(split[0]);
			good.setName(split[1]);
			good.setPrice(split[2]);
			good.setCount(split[3]);
			
			BoundListOperations listOps = redisTemplate.boundListOps("goods_list");
			BoundZSetOperations zSetOps = redisTemplate.boundZSetOps("goods_zset");
			
			listOps.leftPush(good);
			zSetOps.add(good, 1);
		}
	}
}
