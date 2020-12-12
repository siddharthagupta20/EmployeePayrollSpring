package com.cg.emppayroll.exceptions;

public class DetailsNotProvidedExceptions extends IllegalArgumentException {
	private String msg;
	
	public DetailsNotProvidedExceptions(String msg) {
		super(msg);
		this.msg = msg;
	}
}
