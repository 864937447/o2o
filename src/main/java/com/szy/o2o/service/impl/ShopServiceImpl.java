package com.szy.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szy.o2o.dao.ShopDao;
import com.szy.o2o.dto.ImageHolder;
import com.szy.o2o.dto.ShopExecution;
import com.szy.o2o.entity.Shop;
import com.szy.o2o.enuma.ShopStateEnum;
import com.szy.o2o.exceptions.ShopOperationException;
import com.szy.o2o.service.ShopService;
import com.szy.o2o.util.ImageUtil;
import com.szy.o2o.util.PageCalculator;
import com.szy.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution se = new ShopExecution();
		if(shopList != null && shopList.size()>0){
			se.setShopList(shopList);
			se.setCount(count);
		}else{
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop,ImageHolder thumbnail) {
		// 空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new java.sql.Date(System.currentTimeMillis()));
			shop.setLastEditTime(new java.sql.Date(System.currentTimeMillis()));
			// 添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (thumbnail.getImage() != null) {
					// 存储图片
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error" + e.getMessage());
					}
				}
				// 更新店鋪的图片地址
				effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					throw new ShopOperationException("图片更新地址失败");
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop,ImageHolder thumbnail) {
		// 获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExecution modifyShop(Shop shop,ImageHolder thumbnail)
			throws ShopOperationException {
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			try {
				// 1.判断是否需要处理图片
				if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop,thumbnail);
				}
				// 2.更新店铺信息
				shop.setLastEditTime(new java.sql.Date(System.currentTimeMillis()));
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new ShopOperationException("modifyShop error:" + e.getMessage());
			}
		}
	}

}
