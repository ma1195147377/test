package com.zheng.entity;

public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String hobby;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public User( String name, String pwd, String hobby) {

        this.name = name;
        this.pwd = pwd;
        this.hobby = hobby;
    }

    public User(Integer id, String name, String pwd, String hobby) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
