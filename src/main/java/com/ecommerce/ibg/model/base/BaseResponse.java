package com.ecommerce.ibg.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(Builder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.data = (T) builder.data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class Builder<T> {
        private Integer status;
        private String message;
        private T data;

        public Builder(Integer status, String message) {
            this.status = status;
            this.message = message;
        }

        public static Builder with(int status, String message) {
            return new Builder(status, message);
        }

        public Builder with(T data) {
            this.data = data;
            return this;
        }

        public BaseResponse<T> build() {
            return new BaseResponse<>(this);
        }
    }
}
