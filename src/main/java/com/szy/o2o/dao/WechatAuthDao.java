package com.szy.o2o.dao;

import com.szy.o2o.entity.WechatAuth;

public interface WechatAuthDao {
	/**
	 * 
	 * 功能说明:通过openId查询对应本平台的微信帐号
	 * @param openId
	 * @return
	 * @date 2018年4月5日下午12:21:10
	 */
	WechatAuth queryWechatInfoByOpenId(String openId);
	
	/**
	 * 
	 * 功能说明:添加对应本平台的微信帐号
	 * @param wechatAuth
	 * @return
	 * @date 2018年4月5日下午12:21:54
	 */
	int insertWechatAuth(WechatAuth wechatAuth);
}
