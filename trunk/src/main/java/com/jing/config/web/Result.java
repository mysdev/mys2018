package com.jing.config.web;

public class Result  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5645888938727620455L;

	// 弹出框类型 >1：成功，<1：失败，其他：警告
	private int code;
	// 弹出框信息
	private String message;
	// 弹出框停留时间
	private int time;

	private Object data;

	public Result() {

	}

	public Result(String message, int time, int code) {
		super();
		this.code = code;
		this.message = message;
		this.time = time;
	}

	/**
	 * 成功提示框
	 * 
	 * @param message
	 * @return
	 */
	public static Result getSuccMsgResult(String message) {
		return new Result(message, 2, 1);
	}

	public static Result getDefaultSuccMsgResult() {
		return new Result("操作成功！", 2, 1);
	}

	public static Result getDefaultSuccMsgResult(Object data) {
		Result result = new Result("操作成功！", 2, 1);
		result.setData(data);
		return result;
	}

	/**
	 * 错误提示框
	 * 
	 * @param message
	 * @return
	 */
	public static Result getErroMsgResult(String message) {
		return new Result(message, 2, -1);
	}

	/**
	 * 警告提示框
	 * 
	 * @param message
	 * @return
	 */
	public static Result getWaringMsgResult(String message) {
		return new Result(message, 2, 0);
	}

	/**
	 * 提示信息框
	 * 
	 * @param message
	 * @return
	 */
	public static Result getInfoMsgResult(String message) {
		return new Result(message, 2, -2);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setTrue() {
		this.code = 1;
	}

	public void setFalse() {
		this.code = 0;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
