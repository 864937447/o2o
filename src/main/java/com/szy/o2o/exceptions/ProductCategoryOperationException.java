package com.szy.o2o.exceptions;

public class ProductCategoryOperationException extends RuntimeException{

	private static final long serialVersionUID = 1703701655408691873L;
	
	public ProductCategoryOperationException(String msg){
		super(msg);
	}
	
}
