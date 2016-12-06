package com.feicuiedu.retrofitdemo.retrofitPost;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gqq on 2016/12/6.
 */

public class UserResult {


    /**
     * errcode : 1
     * errmsg : 注册成功！
     * tokenid : 171
     */

    @SerializedName("errcode")
    private int code;
    private String errmsg;
    private int tokenid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getTokenid() {
        return tokenid;
    }

    public void setTokenid(int tokenid) {
        this.tokenid = tokenid;
    }
}
