package com.ssj.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssj.util.PageUtils;

@Controller
@SuppressWarnings("all")
public class GoodsController {
	@Resource
	private RedisTemplate redisTemplate;
	
	@RequestMapping("list1")
	public String list1(Model model,String currentPage) {
		BoundListOperations listOps = redisTemplate.boundListOps("goods_list");
		BoundZSetOperations zSetOps = redisTemplate.boundZSetOps("goods_zset");
		
		int count = 106;
		int pageSize=10;
		
		PageUtils page = new PageUtils(currentPage, count, pageSize);
		
		List goods = listOps.range(page.getPageRecord(), page.getPageRecord()+pageSize-1);
		model.addAttribute("goods", goods);
		model.addAttribute("page", page.getPage());
		return "list1";
	}
	
	@RequestMapping("list2")
	public String list2(Model model,String currentPage) {
		BoundZSetOperations zSetOps = redisTemplate.boundZSetOps("goods_zset");
		
		int count = 106;
		int pageSize=10;
		
		PageUtils page = new PageUtils(currentPage, count, pageSize);
		
		Set goods = zSetOps.reverseRange(page.getPageRecord(), page.getPageRecord()+pageSize-1);
		model.addAttribute("goods", goods);
		model.addAttribute("page", page.getPage());
		return "list2";
	}
}
