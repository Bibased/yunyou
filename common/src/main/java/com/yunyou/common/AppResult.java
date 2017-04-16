package com.yunyou.common;

import java.io.Serializable;

/**
 * Created by dell on 2017/3/13.
 */
public class AppResult implements Serializable{
    private static final long serialVersionUID = 3718141872233075997L;
    public Boolean isSuccess;
    public String failedMsg;

    public AppResult() {
        this.isSuccess = true;
    }

    public AppResult(String failedMsg) {
        isSuccess = false;
        this.failedMsg = failedMsg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getFailedMsg() {
        return failedMsg;
    }

    public void setFailedMsg(String failedMsg) {
        this.failedMsg = failedMsg;
    }
}
