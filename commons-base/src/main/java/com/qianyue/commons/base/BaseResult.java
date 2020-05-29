package com.qianyue.commons.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 描述:
 *
 * @auther qianyue
 * @date 2020/5/23 7:51
 */
public abstract class BaseResult implements Result {

    private static final long serialVersionUID = 1L;

    private boolean success;
    @JsonProperty("error_message")
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public BaseResult(boolean success) {
        this.success = success;
    }

    public BaseResult(String errorMessage, boolean success) {
        this.errorMessage = errorMessage;
        this.success = success;
    }

    @Override
    public boolean success() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BaseResult [errorMessage=" + errorMessage + ", success=" + success + "]";
    }
}