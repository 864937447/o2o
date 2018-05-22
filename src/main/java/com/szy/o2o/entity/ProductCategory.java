package com.szy.o2o.entity;

import java.util.Date;
/**
 * 
 * 描述:商品类别
 * @author sunzhenyang
 * @date 2018年3月20日下午1:56:21
 * @version 1.0
 */
public class ProductCategory {
	private Long productCategoryId;
	//店铺id
	private Long shopId;
	//商品类别名称
	private String productCategoryName;
	//商品优先级
	private Integer priority;
	//商品类别创建时间
	private Date createTime;
	
	public ProductCategory() {
		super();
	}
	
	public ProductCategory(Long productCategoryId, Long shopId, String productCategoryName, Integer priority,
			Date createTime) {
		super();
		this.productCategoryId = productCategoryId;
		this.shopId = shopId;
		this.productCategoryName = productCategoryName;
		this.priority = priority;
		this.createTime = createTime;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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
	
}
