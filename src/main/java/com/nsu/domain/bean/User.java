package com.nsu.domain.bean;

import java.io.Serializable;

/**
 * 内容：
 * 用户：User
 * @author: wangqiao
 * @time: 2019/9/19
 */
public class User implements Serializable {
    private Long id;  //编号
    private String n_name; //昵称
    private String p_number;  //手机号
    private String email;  //邮箱
    private String pwd;  //密码
    private String h_photo; //头像图片
    private String power; //权限
    private String autograph;//签名

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getH_photo() {
        return h_photo;
    }

    public void setH_photo(String h_photo) {
        this.h_photo = h_photo;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", n_name='" + n_name + '\'' +
                ", p_number='" + p_number + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", h_photo='" + h_photo + '\'' +
                ", power='" + power + '\'' +
                ", autograph='" + autograph + '\'' +
                '}';
    }
}
