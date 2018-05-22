package com.szy.o2o.util;

public class PathUtil {
	// 获取文件分隔符
	private static String seperator = System.getProperty("file.separator");

	/**
	 * 
	 * 功能说明:获取项目图片根路径
	 * @return 根路径
	 * @date 2018年3月22日上午11:46:28
	 */
	public static String getImgBasePath() {
		// 获取操作系统名称
		String os = System.getProperty("os.name");
		String basePath = "";
		// 根据系统的不同存储在不同的目录
		if (os.toLowerCase().startsWith("win")) {
			basePath = "F:/projectdev/image/";
		} else {
			basePath = "/home/szy/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	/**
	 * 
	 * 功能说明:项目图片子路径
	 * @param shopId
	 * @return 图片子路径
	 * @date 2018年3月22日上午11:47:19
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
