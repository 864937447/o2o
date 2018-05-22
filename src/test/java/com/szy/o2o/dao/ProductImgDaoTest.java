package com.szy.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.szy.o2o.BaseTest;
import com.szy.o2o.dao.ProductImgDao;
import com.szy.o2o.entity.ProductImg;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest{
	@Autowired
	private ProductImgDao productImgDao;
	
	@Test
	public void testABatchInsertProductImg(){
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(1L);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setImgDesc("测试图片2");
		productImg2.setPriority(2);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(1L);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int batchInsertProductImg = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, batchInsertProductImg);
	}
	
	@Test
	public void testBQueryProductImgList(){
		List<ProductImg> productImgList = productImgDao.queryProductImgList(1L);
		assertEquals(2,productImgList.size());
	}
	
	@Test
	public void testCDeleteProductImgByProductId(){
		int deleteProductImgByProductId = productImgDao.deleteProductImgByProductId(1L);
		assertEquals(2,deleteProductImgByProductId);
	}
}
