package com.szy.o2o.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.szy.o2o.BaseTest;
import com.szy.o2o.entity.ShopCategory;

public class ShopCategoryTest extends BaseTest{

	@Autowired
	private ShopCategoryDao shopCategoryDao; 
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Ignore
	public void testShopCategory() {
		ShopCategory testShop = new ShopCategory();
		ShopCategory per = new ShopCategory();
		per.setShopCategoryId(15L);
		testShop.setParent(per);
		List<ShopCategory> queryShopCategory = shopCategoryDao.queryShopCategory(testShop);
		System.out.println(queryShopCategory.get(0).getShopCategoryName());
		assertEquals(1, queryShopCategory.size());
	}

}
