package com.jing.system.login.session;


public class SessionAttrNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String attrKey;

	public SessionAttrNotFoundException(String attrKey){
		super("Not found attr["+attrKey+"] in session scope");
	}

	public String getAttrKey() {
		return attrKey;
	}

	public void setAttrKey(String attrKey) {
		this.attrKey = attrKey;
	}
	
	
}
