package com.szy.o2o.exceptions;

public class ProductOperationException extends RuntimeException {
	private static final long serialVersionUID = 521548348455438405L;
	
	public ProductOperationException(String msg){
		super(msg);
	}
}
