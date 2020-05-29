package com.qianyue.commons.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.time.Instant;


/**
 * 响应信息主体
 *
 * @param <T>
 * @author lengleng
 */
@ToString
public class R<T> extends BaseResult implements DataResult<T> {

	private static final long serialVersionUID = 1L;
	private T data;
	@JsonProperty("server_time")
	private long serverTime = Instant.now().getEpochSecond();

	public R() {
		super(false);
	}

	public R(boolean success) {
		super(success);
	}

	public R(String err, boolean success, T data) {
		super(err, success);
		this.data = data;
	}

	@Override
	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public long getServerTime() {
		return serverTime;
	}

	public static <T> ResultBuilder<T> newBuilder() {
		return new R.ResultBuilder<>();
	}

	public static final class ResultBuilder<T> {
		private R<T> result;

		private ResultBuilder() {
			result = new R<>();
		}

		public ResultBuilder<T> setSuccess(boolean success) {
			result.setSuccess(success);
			return this;
		}

		public ResultBuilder<T> setData(T data) {
			result.setData(data);
			return this;
		}

		public ResultBuilder<T> setErr(String err) {
			result.setError(err);
			return this;
		}

		public R<T> builder() {
			return this.result;
		}

	}
}