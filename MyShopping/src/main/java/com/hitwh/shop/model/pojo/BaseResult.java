package com.hitwh.shop.model.pojo;

/**
 * @ClassName BaseResult
 * @Description 基本返回结果
 * @Author 孙一恒
 * @Date 2020/6/1 18:02
 * @Version 1.0
 **/
public class BaseResult<T> {
    private boolean success;//是否成功
    private String message;//提示信息，一般为ConstUtils中设定的字符串
    private T data;

    public BaseResult() {
    }

    public BaseResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public void construct(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
