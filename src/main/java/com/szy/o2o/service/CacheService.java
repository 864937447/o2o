package com.szy.o2o.service;

public interface CacheService {
	/**
	 * 
	 * 功能说明:依据key前缀删除匹配该模式下的所有key-value 如传入:shopcategory,则shopcategory_allfirstlevel等
	 * 以shopcategory打头的key_value都会被清空
	 * @param keyPrefix
	 * @date 2018年4月8日下午10:01:27
	 */
	void removeFromCache(String keyPrefix);
}
