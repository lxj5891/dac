package org.antonyframework.web.common;

public class AppResult {

	private int status;
	private String msg;
	private Object result;
	private String json;
	private Integer totleCount;
	
	

	public Integer getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(Integer totleCount) {
		this.totleCount = totleCount;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}



}
