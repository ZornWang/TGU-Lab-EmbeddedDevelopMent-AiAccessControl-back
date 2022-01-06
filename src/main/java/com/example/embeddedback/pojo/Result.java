package com.example.embeddedback.pojo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.embeddedback.pojo.state.ResponseState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 *   接口返回数据格式
 * @author scott
 * @email jeecgos@163.com
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	@ApiModelProperty(value = "成功标志")
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "返回处理消息")
	private String message = "请求成功";

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer statusCode;
	
	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "返回数据对象")
	private T data;

	/**
	 * 错误状态吗 errorCode
	 */
	private Integer errorCode;

	private String errorMessage;

	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private long timestamp = System.currentTimeMillis();


	public Result() {
		
	}
	
	public Result<T> success(String message) {
		this.message = message;
		this.statusCode = ResponseState.SUCCESS.getStatusCode();
		this.success = true;
		return this;
	}

	public static <T> Result<T> OK() {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setStatusCode(ResponseState.SUCCESS.getStatusCode());
		r.setMessage(ResponseState.SUCCESS.getMessage());
		return r;
	}

	public static <T> Result<T> OK(T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setStatusCode(ResponseState.SUCCESS.getStatusCode());
		r.setMessage(ResponseState.SUCCESS.getMessage());
		r.setData(data);
		return r;
	}

	public static <T> Result<T> OK(String message) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setStatusCode(ResponseState.SUCCESS.getStatusCode());
		r.setMessage(message);
		return r;
	}


	public static <T> Result<T> OK(String msg, T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setStatusCode(ResponseState.SUCCESS.getStatusCode());
		r.setMessage(msg);
		r.setData(data);
		return r;
	}

	public static <T> Result<T> error() {
		Result<T> r = new Result<T>();
		r.setSuccess(false);
		r.setErrorCode(ResponseState.ERROR.getStatusCode());
		r.setErrorMessage(ResponseState.ERROR.getMessage());
		r.setMessage(null);
		return r;
	}

	public static <T> Result<T> error(String msg,int status, T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(false);
		r.setErrorCode(status);
		r.setErrorMessage(msg);
		r.setData(data);
		r.setMessage(null);
		return r;
	}

	public static <T> Result<T> error(String msg) {
		return error(msg,ResponseState.ERROR.getStatusCode());
	}

	public static <T> Result<T> error(String msg,int status) {
		Result<T> r = new Result<>();
		r.setErrorCode(status);
		r.setErrorMessage(msg);
		r.setSuccess(false);
		r.setMessage(null);
		return r;
	}



	@JsonIgnore
	private String onlTable;

}