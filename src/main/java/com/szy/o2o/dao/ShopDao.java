package com.szy.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szy.o2o.entity.Shop;

public interface ShopDao {
	
	/**
	 * 
	 * 功能说明:分页查询店铺，可输入的条件有：店铺名(模糊)，店铺状态，店铺类别，区域Id,owner
	 * @param shopCondition
	 * @param rowIndex 从第几行开始取数据
	 * @param pageSize 返回的条数
	 * @return
	 * @date 2018年3月25日下午6:50:26
	 */
	List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
			@Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);
	
	/**
	 * 
	 * 功能说明:返回queryShopList总数
	 * @param shopCondition
	 * @return
	 * @date 2018年3月25日下午7:13:05
	 */
	int queryShopCount(@Param("shopCondition")Shop shopCondition);
	/**
	 * 
	 * 功能说明:通过shop id 查询店铺
	 * @param shopId
	 * @return shop
	 * @date 2018年3月25日上午11:18:35
	 */
	Shop queryByShopId(long shopId);
	
	/**
	 * 
	 * 功能说明:新增店铺
	 * @param shop
	 * @return 1.成功 -1.失败
	 * @date 2018年3月21日下午8:22:19
	 */
	int insertShop(Shop shop);
	
	/**
	 * 
	 * 功能说明:更新店铺信息
	 * @param shop
	 * @return 1.成功 -1.失败
	 * @date 2018年3月22日上午10:26:30
	 */
	int updateShop(Shop shop);
}
