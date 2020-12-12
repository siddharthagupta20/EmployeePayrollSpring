package com.cg.emppayroll.exceptions;

public class UserNotFound extends IllegalArgumentException{
	private String msg;
	public UserNotFound(String msg) {
		super(msg);
		this.msg = msg;
	}
}
