package com.neu.bean;

/**
 * 对应用户表user的JavaBean User JavaBean
 *
 */
public class User {
    // 代码编写处
    private String id;
    private String userName;
    private String password;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
