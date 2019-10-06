package com.nsu.domain.bean;

import java.io.Serializable;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/2
 */
public class Welfare implements Serializable {
    private Long o_id;          //公益平台id：o_id
    private Long id;            //用户id：id
    private String address;     //地址：address
    private String bs_url;      //营业执照：bs_url

    public Long getO_id() {
        return o_id;
    }

    public void setO_id(Long o_id) {
        this.o_id = o_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBs_url() {
        return bs_url;
    }

    public void setBs_url(String bs_url) {
        this.bs_url = bs_url;
    }

    @Override
    public String toString() {
        return "Welfare{" +
                "o_id=" + o_id +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", bs_url='" + bs_url + '\'' +
                '}';
    }
}
