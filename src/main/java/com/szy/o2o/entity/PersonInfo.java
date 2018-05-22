package com.szy.o2o.entity;

import java.util.Date;
/**
 * 
 * 描述:个人信息
 * @author sunzhenyang
 * @date 2018年3月20日上午10:39:36
 * @version 1.0
 */
public class PersonInfo {
	//用户ID
	private Long userId;
	//姓名
	private String userName;
	//头像图片地址
	private String profileImg;
	//邮箱
	private String email;
	//性别
	private String gender;
	//禁用帐号
	private Integer enableStatus;
	//1.顾客 2.店家 3.超级管理员
	private Integer userType;
	//创建时间
	private Date createTime;
	//最近一次操作时间
	private Date lastEditTime;
	
	public PersonInfo() {
		super();
	}
	
	public PersonInfo(Long userId, String userName, String profileImg, String email, String gender, Integer enableStaus,
			Integer userType, Date createTime, Date lastEditTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.profileImg = profileImg;
		this.email = email;
		this.gender = gender;
		this.enableStatus = enableStaus;
		this.userType = userType;
		this.createTime = createTime;
		this.lastEditTime = lastEditTime;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getEnableStaus() {
		return enableStatus;
	}
	public void setEnableStaus(Integer enableStaus) {
		this.enableStatus = enableStaus;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
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
	
	
}
