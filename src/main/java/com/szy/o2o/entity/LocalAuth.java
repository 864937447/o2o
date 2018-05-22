package com.szy.o2o.entity;

import java.util.Date;

/**
 * 
 * 描述:本地帐号
 * @author sunzhenyang
 * @date 2018年3月20日上午10:08:54
 * @version 1.0
 */
public class LocalAuth {
	private Long localAuthId; 
	private String username;
	private String password;
	private Date createTime;
	private Date lastEditTime;
	private PersonInfo personInfo;
	
	public LocalAuth() {
		super();
	}
	
	public LocalAuth(Long localAuthId, String username, String password, Date createTime, Date lastEditTime,
			PersonInfo personInfo) {
		super();
		this.localAuthId = localAuthId;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.lastEditTime = lastEditTime;
		this.personInfo = personInfo;
	}

	public Long getLocalAuthId() {
		return localAuthId;
	}
	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
	
}
