package com.szy.o2o;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 描述:配置spring和junit整合，junit启动时加载springIOC容器
 * @author sunzhenyang
 * @date 2018年3月20日下午10:58:56
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-redis.xml"})
public class BaseTest {
	@Test
	public void test(){
		
	}
}
