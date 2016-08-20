package com.springapp.mvc.model;

/**
 * @author gjy
 * @Description: -com.springapp.mvc.model
 * @date 2016/8/10 11:16
 */
public class Msg {
    private  String status="-1";;
    private  String msg="签约失败";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
