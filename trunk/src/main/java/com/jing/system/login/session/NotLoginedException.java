package com.jing.system.login.session;


public class NotLoginedException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	public NotLoginedException() {
		super("User not logined.");
	}


	public NotLoginedException( String msg) {
		super(msg);
	}

	public NotLoginedException( String msg, Throwable cause) {
		super(msg,cause);
	}
}
