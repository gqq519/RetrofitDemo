package com.feicuiedu.retrofitdemo.retrofitTest;

/**
 * Created by Administrator on 2016/12/7 0007.
 */

public class MultUser {

    /**
     * name : yt59856b15cf394e7b84a7d48447d16098
     * username : xc62
     * nickname : 555
     * password : 123456
     * uuid : 0F8EC12223174657B2E842076D54C361
     */

    private String name;
    private String username;
    private String nickname;
    private String password;
    private String uuid;

    public MultUser(String name, String username, String nickname, String password, String uuid) {
        this.name = name;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
