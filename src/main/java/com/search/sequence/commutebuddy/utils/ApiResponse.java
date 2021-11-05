package com.search.sequence.commutebuddy.utils;


public class ApiResponse<T> {

    private int status;
    private String message;
    private T result;
    private String userId;

    public ApiResponse(int status, String message, String userId, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}
