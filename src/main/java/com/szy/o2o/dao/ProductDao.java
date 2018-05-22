package com.szy.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szy.o2o.entity.Product;

public interface ProductDao {
	/**
	 * 
	 * 功能说明:查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺Id，商品类别
	 * 
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return List<Product>
	 * @date 2018年3月30日上午9:00:52
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	/**
	 * 
	 * 功能说明:通过productId查询唯一的商品信息
	 * 
	 * @param productId
	 * @return
	 * @date 2018年3月31日下午1:43:56
	 */
	Product queryProductById(long productId);

	/**
	 * 
	 * 功能说明:插入商品
	 * 
	 * @param product
	 * @return
	 * @date 2018年3月30日上午9:03:02
	 */
	int insertProduct(Product product);

	/**
	 * 
	 * 功能说明:更新商品信息
	 * 
	 * @param product
	 * @return
	 * @date 2018年3月31日下午1:44:57
	 */
	int updateProduct(Product product);

	/**
	 * 删除商品类别之前，将商品类别ID置为空
	 * 
	 * @param productCategoryId
	 * @return
	 */
	int updateProductCategoryToNull(long productCategoryId);

	/**
	 * 
	 * 功能说明:删除指定商品下的所有详情图
	 * 
	 * @param productId
	 * @return
	 * @date 2018年3月31日下午1:45:32
	 */
	int deleteProductImgByProductId(long productId);

	/**
	 * 查询对应的商品总数
	 * 
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);
}
