package com.szy.o2o.dao;

import com.szy.o2o.entity.PersonInfo;

public interface PersonInfoDao {
	/**
	 * 
	 * 功能说明:通过用户Id查询用户
	 * @param userId
	 * @return
	 * @date 2018年4月5日下午12:18:34
	 */
	PersonInfo queryPersonInfoById(long userId);
	
	/**
	 * 
	 * 功能说明:添加用户信息
	 * @param personInfo
	 * @return
	 * @date 2018年4月5日下午12:19:20
	 */
	int insertPersonInfo(PersonInfo personInfo);
}
