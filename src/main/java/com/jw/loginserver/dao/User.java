package com.jw.loginserver.dao;

public class User {

    private Integer userid;
    private String account;
    private String passwd;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
