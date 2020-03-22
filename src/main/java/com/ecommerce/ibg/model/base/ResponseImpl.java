package com.ecommerce.ibg.model.base;


public class ResponseImpl implements Response {
    private int status;
    private String message;
    private Object data;

    public static Response ok() {
        return new ResponseImpl();
    }

    @Override
    public Response with(int status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    @Override
    public Response with(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public <T> BaseResponse<T> build() {
        return new BaseResponse<T>(status, message, (T) data);
    }
}
