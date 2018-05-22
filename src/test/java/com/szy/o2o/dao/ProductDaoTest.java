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
import com.szy.o2o.entity.Product;
import com.szy.o2o.entity.ProductCategory;
import com.szy.o2o.entity.ProductImg;
import com.szy.o2o.entity.Shop;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest{
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;
	
	@Test
	@Ignore
	public void testAInsertProduct(){
		Shop shop1 = new Shop();
		shop1.setShopId(14L);
		ProductCategory pc1 = new ProductCategory();
		pc1.setProductCategoryId(22L);
		//初始化三个商品实例并添加进shopId为1的店铺里
		//同时商品类别Id也为1
		Product product1 = new Product();
		product1.setProductName("测试1");
		product1.setProductDesc("测试1");
		product1.setImgAddr("测试1");
		product1.setPriority(2);
		product1.setEnableStatus(1);
		product1.setCreateTime(new Date());
		product1.setLastEditTime(new Date());
		product1.setShop(shop1);
		product1.setProductCategory(pc1);
		
		Product product2 = new Product();
		product2.setProductName("测试2");
		product2.setProductDesc("测试2");
		product2.setImgAddr("测试2");
		product2.setPriority(3);
		product2.setEnableStatus(1);
		product2.setCreateTime(new Date());
		product2.setLastEditTime(new Date());
		product2.setShop(shop1);
		product2.setProductCategory(pc1);
		
		Product product3 = new Product();
		product3.setProductName("测试3");
		product3.setProductDesc("测试3");
		product3.setImgAddr("测试3");
		product3.setPriority(4);
		product3.setEnableStatus(1);
		product3.setCreateTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pc1);
		
		int effectedNum = productDao.insertProduct(product1);
			assertEquals(1, effectedNum);
			effectedNum = productDao.insertProduct(product2);
			assertEquals(1, effectedNum);
			effectedNum = productDao.insertProduct(product3);
			assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testBqueryProductList(){
		int rowIndex = 0;
		int pageSize = 5;
		Product productCondition = new Product();
		Shop shop = new Shop();
		shop.setShopId(14L);
		ProductCategory pro = new ProductCategory();
		pro.setProductCategoryId(22L);
		productCondition.setShop(shop);
		productCondition.setProductCategory(pro);
		productCondition.setProductName("测试");
		productCondition.setEnableStatus(0);
		List<Product> queryProductList = productDao.queryProductList(productCondition, rowIndex, pageSize);
		for (Product product : queryProductList) {
			System.out.println(product.getProductName());
		}
	}
	@Test
	@Ignore
	public void testQueryProductById(){
		long productId = 1;
		// 初始化两个商品详情图实例作为productId为1的商品下的详情图片
		// 批量插入到商品详情图表中
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片3");
		productImg1.setImgDesc("测试图片3");
		productImg1.setPriority(2);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(productId);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片4");
		productImg2.setPriority(3);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(productId);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
		// 查询productId为1的商品信息并校验返回的详情图实例列表size是否为2
		Product product = productDao.queryProductById(productId);
		assertEquals(2, product.getProductImgList().size());
		// 删除新增的这两个商品详情图实例
		effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}
	
	@Test
	@Ignore
	public void testDUpdateProduct() throws Exception {
		Product product = new Product();
		ProductCategory pc = new ProductCategory();
		Shop shop = new Shop();
		shop.setShopId(14L);
		pc.setProductCategoryId(5L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductName("第二个产品");
		product.setProductCategory(pc);
		// 修改productId为1的商品的名称
		// 以及商品类别并校验影响的行数是否为1
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testEUpdateProductCategoryToNull() {
		// 将productCategoryId为2的商品类别下面的商品的商品类别置为空
		int effectedNum = productDao.updateProductCategoryToNull(4L);
		assertEquals(1, effectedNum);
	}
}
