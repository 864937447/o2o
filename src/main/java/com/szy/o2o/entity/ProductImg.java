package com.szy.o2o.entity;

import java.util.Date;
/**
 * 
 * 描述:商品图片
 * @author sunzhenyang
 * @date 2018年3月20日下午1:55:29
 * @version 1.0
 */
public class ProductImg {
	private Long productImgId;
	//图片地址
	private String imgAddr;
	//图片说明
	private String imgDesc;
	//权重
	private Integer priority;
	//创建时间
	private Date createTime;
	//商品详情图片
	private Long productId;
	
	public ProductImg() {
		super();
	}
	
	public ProductImg(Long productImgId, String imgAddr, String imgDesc, Integer priority, Date createTime,
			Long productId) {
		super();
		this.productImgId = productImgId;
		this.imgAddr = imgAddr;
		this.imgDesc = imgDesc;
		this.priority = priority;
		this.createTime = createTime;
		this.productId = productId;
	}

	public Long getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}
	public String getImgAddr() {
		return imgAddr;
	}
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}
	public String getImgDesc() {
		return imgDesc;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
