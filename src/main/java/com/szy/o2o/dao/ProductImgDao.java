package com.szy.o2o.dao;

import java.util.List;

import com.szy.o2o.entity.ProductImg;

public interface ProductImgDao {
	
	List<ProductImg> queryProductImgList(long productId);
	
	/**
	 * 
	 * 功能说明:批量添加商品详情图片
	 * @param productImgList
	 * @return
	 * @date 2018年3月30日上午9:08:40
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
	
	int deleteProductImgByProductId(long productId);
}
