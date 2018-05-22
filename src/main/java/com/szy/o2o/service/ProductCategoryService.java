package com.szy.o2o.service;

import java.util.List;

import com.szy.o2o.dto.ProductCategoryExecution;
import com.szy.o2o.entity.ProductCategory;
import com.szy.o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	/**
	 * 
	 * 功能说明:查询指定某个店铺下的所有商品类别信息
	 * @param shopId
	 * @return List<ProductCategory>
	 * @date 2018年3月28日下午10:41:22
	 */
	public List<ProductCategory> getProductCategoryList(long shopId);
	
	/**
	 * 
	 * 功能说明:
	 * @param productCategoryList
	 * @return
	 * @date 2018年3月28日下午10:43:39
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProduCategory(List<ProductCategory> productCategoryList)
		throws ProductCategoryOperationException;
	
	/**
	 * 
	 * 功能说明:将此类别下的商品里的类别id置为空，再删除该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return ProductCategoryExecution
	 * @throws ProductCategoryOperationException
	 * @date 2018年3月29日上午8:57:39
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId)
		throws ProductCategoryOperationException;
}
