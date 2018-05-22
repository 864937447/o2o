package com.szy.o2o.dao;

import java.util.List;

import com.szy.o2o.entity.Area;

public interface AreaDao {
	/**
	 * 功能说明:列出区域列表
	 * @return areaList
	 * @date 2018年3月21日上午10:52:13
	 */
	List<Area> queryArea();
}
