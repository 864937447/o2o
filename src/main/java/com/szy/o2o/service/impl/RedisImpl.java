package com.szy.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szy.o2o.cache.JedisUtil;

@Service
public class RedisImpl {
		@Autowired
		private JedisUtil jedisKeys;

		public String getString() {
			// 定义redis的key
			String key = "names";
			String names = "";
			// 判断key是否存在
			if (!jedisKeys.exists(key)) {
				jedisKeys.set(key, "hello");
			} else {
				// 若存在，则直接从redis里面取出相应数据
				names = jedisKeys.get(key);
			}
			return names;
		}
}
