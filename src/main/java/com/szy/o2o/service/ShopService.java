package com.szy.o2o.service;

import java.io.InputStream;

import com.szy.o2o.dto.ImageHolder;
import com.szy.o2o.dto.ShopExecution;
import com.szy.o2o.entity.Shop;
import com.szy.o2o.exceptions.ShopOperationException;

public interface ShopService {

	/**
	 * 
	 * 功能说明:根据shopCondition分页返回相应店铺列表
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @date 2018年3月26日上午10:01:11
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

	/**
	 * 
	 * 功能说明:通过店铺Id获取店铺信息
	 * 
	 * @param shopId
	 * @return
	 * @date 2018年3月25日上午11:47:54
	 */
	Shop getByShopId(long shopId);

	ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException;

	/**
	 * 
	 * 功能说明:注册店铺信息，包括图片处理
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 * @date 2018年3月25日上午11:46:59
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
