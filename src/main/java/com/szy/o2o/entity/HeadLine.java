package com.szy.o2o.entity;
import java.util.Date;
/**
 * 
 * 描述:头条新闻
 * @author sunzhenyang
 * @date 2018年3月20日上午10:39:08
 * @version 1.0
 */
public class HeadLine {
	//头条ID
	private Long lineId;
	//头条名称
	private String lineName;
	//头条链接
	private String lineLink;
	//头条图片
	private String lineImg;
	//优先级
	private Integer priority;
	//头条显示0.不可用 1.可用
	private Integer enableStatus;
	//创建时间
	private Date createTime;
	//更新时间
	private Date lastEditTime;
	
	public HeadLine() {
		super();
	}
	public HeadLine(Long lineId, String lineName, String lineLink, String lineImg, Integer priority,
			Integer enableStatus, Date createTime, Date lastEditTime) {
		super();
		this.lineId = lineId;
		this.lineName = lineName;
		this.lineLink = lineLink;
		this.lineImg = lineImg;
		this.priority = priority;
		this.enableStatus = enableStatus;
		this.createTime = createTime;
		this.lastEditTime = lastEditTime;
	}
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getLineLink() {
		return lineLink;
	}
	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}
	public String getLineImg() {
		return lineImg;
	}
	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
