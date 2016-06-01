package com.fate.restful.et.common.bean;

/**
 * @author WangGuoguo
 * 2016年6月1日21:55:41
 */
public class ReqResult {
	private int resultCode;
	private Object returnObject;
	private Object returnMessage;
	
	public static final int CODE_SUCCESS = 1100;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	public Object getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(Object returnMessage) {
		this.returnMessage = returnMessage;
	}
}
