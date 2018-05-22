package com.szy.o2o.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szy.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 
	 * 功能说明:通过shop id 查询店铺商品类别
	 * @param long shopId
	 * @return list<ProductCategory>
	 * @date 2018年3月27日下午7:54:26
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);
	
	/**
	 * 
	 * 功能说明:批量新增商品类别
	 * @param productCategoryList
	 * @return 影响的行数
	 * @date 2018年3月28日上午11:40:17
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	int deleteProductCategory(@Param("productCategoryId") long productCategory,@Param("shopId") long shopId);
}
