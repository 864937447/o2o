package com.szy.o2o.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.szy.o2o.BaseTest;
import com.szy.o2o.cache.JedisUtil;
import com.szy.o2o.service.impl.RedisImpl;

public class RedisTest extends BaseTest{
	@Autowired
	private RedisImpl redis;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(redis.getString());
	}

}
