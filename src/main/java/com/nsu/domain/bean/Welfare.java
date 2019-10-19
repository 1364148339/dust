package com.nsu.domain.bean;

import java.io.Serializable;

/**
 * 内容：
 * 公益平台
 * @author: wangqiao
 * @time: 2019/10/2
 */
public class Welfare implements Serializable {
    private Long o_id;          //公益平台id
    private Long id;            //用户id
    private String province;    //省
    private String city;        //市
    private String address;     //地址
    private String name;        //组织名字
    private String bs_url;      //营业执照
    private String introduce;   //组织介绍
    private String reason;      //申请原因
    private String area;        //区

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

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
