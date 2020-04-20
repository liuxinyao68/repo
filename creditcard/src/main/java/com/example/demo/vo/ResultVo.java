package com.example.demo.vo;

import java.io.Serializable;

public class ResultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean success = true;
    private String message;
    private Object data;
    public  ResultVo(){
    
    }
    public ResultVo(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public ResultVo(boolean success,Object data){

        this.success = success;
        this.data = data;

    }
    public ResultVo fillArg(String s){
        this.message = String.format(this.message,s);
        return  this;
    }
    public static ResultVo CHECK_FAIL = new ResultVo(false,"校验失败:%s");
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static ResultVo getCHECK_FAIL() {
		return CHECK_FAIL;
	}
	public static void setCHECK_FAIL(ResultVo cHECK_FAIL) {
		CHECK_FAIL = cHECK_FAIL;
	}
	@Override
	public String toString() {
		return "ResultVo [success=" + success + ", message=" + message
				+ ", data=" + data + "]";
	}
    
    
    
    
    
    
}
