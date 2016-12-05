package com.feicuiedu.retrofitdemo.okhttpPost;

/**
 * Created by gqq on 2016/12/5.
 */

public class User {
    /**
     * GsonFormat :插件，目的帮我们根据Json字符串生成实体类，下载完，创建一个类
     * alt+insert --> gsonformat
     * {
     "Password":"654321"
     "UserName":"qjd",
     }
     */

    /**
     * Password : 654321
     * UserName : qjd
     */

    private String Password;
    private String UserName;

    public User(String password, String userName) {
        Password = password;
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
