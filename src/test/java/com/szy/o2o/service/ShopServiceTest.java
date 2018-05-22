package com.szy.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.szy.o2o.BaseTest;
import com.szy.o2o.dto.ImageHolder;
import com.szy.o2o.dto.ShopExecution;
import com.szy.o2o.entity.Area;
import com.szy.o2o.entity.PersonInfo;
import com.szy.o2o.entity.Shop;
import com.szy.o2o.entity.ShopCategory;
import com.szy.o2o.enuma.ShopStateEnum;
import com.szy.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	@Ignore
	public void testGetShopList(){
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(15L);
		shopCondition.setShopCategory(sc);
		ShopExecution shopList = shopService.getShopList(shopCondition, 6, 2);
		System.out.println("店铺列表数:"+shopList.getShopList().size());
		System.out.println("店铺总数:"+shopList.getCount());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException,FileNotFoundException{
		Shop shop = new Shop();
		shop.setShopId(14L);
		shop.setShopName("修改后的店铺名称1");
		File shopImg = new File("/Users/baidu/work/image/xinyao.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder("xinyao.jpg",is);
		ShopExecution shopExecution = shopService.modifyShop(shop, imageHolder);
		System.out.println("新的图片地址为:" + shopExecution.getShop().getShopImg());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException{
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(15L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺test14");
		shop.setShopDesc("test1");
		shop.setShopAddr("test2");
		shop.setPhone("test3");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		File shopImg = new File("/Users/baidu/work/image/newlongmao.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
		ShopExecution addShop = shopService.addShop(shop,imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), addShop.getState());
	}
}
