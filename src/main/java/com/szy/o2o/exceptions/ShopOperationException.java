package com.szy.o2o.exceptions;

public class ShopOperationException extends RuntimeException{
	
	private static final long serialVersionUID = 4117974657607780534L;

	public ShopOperationException(String msg){
		super(msg);
	}
}
