package com.szy.o2o.entity;

import java.util.Date;
/**
 * 
 * 描述:微信账号授权
 * @author sunzhenyang
 * @date 2018年3月20日上午10:39:43
 * @version 1.0
 */
public class WechatAuth {
	//微信ID
	private Long wechatAuthId;
	private String openId;
	//创建时间
	private Date createTime;
	//关联personInfo实体类
	private PersonInfo personInfo;
	
	public WechatAuth() {
		super();
	}
	
	public WechatAuth(Long wechatAuthId, String openId, Date createTime, PersonInfo personInfo) {
		super();
		this.wechatAuthId = wechatAuthId;
		this.openId = openId;
		this.createTime = createTime;
		this.personInfo = personInfo;
	}

	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(Long wechatAuth) {
		this.wechatAuthId = wechatAuth;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
