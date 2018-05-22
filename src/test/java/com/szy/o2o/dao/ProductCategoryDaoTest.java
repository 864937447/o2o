package com.szy.o2o.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.szy.o2o.BaseTest;
import com.szy.o2o.entity.ProductCategory;
//JVM:按照代码定义的方法顺序执行 --一般不需要 
//NAME_ASCENDING:按照方法名字顺序去执行
//default:按照默认的顺序执行
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testB() {
		long shopId = 14;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
	}

	@Test
	public void testABatchInsertProductCategory() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别8");
		productCategory.setPriority(8);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(14L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别7");
		productCategory2.setPriority(9);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(14L);
		List<ProductCategory> proList = new ArrayList<ProductCategory>();
		proList.add(productCategory);
		proList.add(productCategory2);
		int effectedNum = productCategoryDao.batchInsertProductCategory(proList);
		assertEquals(2, effectedNum);
	}

	@Test
	public void testCDeleteProductCategory() {
		long shopId = 14;
		List<ProductCategory> proList = productCategoryDao.queryProductCategoryList(shopId);
		for (ProductCategory pro : proList) {
			if (pro.getProductCategoryName().equals("商品类别8") || pro.getProductCategoryName().equals("商品类别7")) {
				int effectedNum = productCategoryDao.deleteProductCategory(pro.getProductCategoryId(), shopId);
				assertEquals(1, effectedNum);
			}
		}

	}
}
