package com.szy.o2o.service;

import java.util.List;

import com.szy.o2o.entity.Area;

public interface AreaService {
	
	public static final String AREALISTKEY = "arealist";
	
	public List<Area> getAreaList();
}
