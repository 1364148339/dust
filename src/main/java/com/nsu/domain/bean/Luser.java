package com.nsu.domain.bean;


import java.io.Serializable;

/**
 * 内容：
 * 爱心人士：Luser
 * @author: wangqiao
 * @time: 2019/10/2
 */

public class Luser implements Serializable {
    private Long l_id;        //爱心人id
    private Long id;          //用户id
    private String name;      //姓名
    private String sex;       //性别
    private Integer age;      //年龄
    private String province;//省
    private String city; //市
    private String address;   //地址
    private String rid_photo; //身份证照片正面url
    private String lid_photo; //身份证照片反面url
    private String area;//区

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

    public Long getL_id() {
        return l_id;
    }

    public void setL_id(Long l_id) {
        this.l_id = l_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRid_photo() {
        return rid_photo;
    }

    public void setRid_photo(String rid_photo) {
        this.rid_photo = rid_photo;
    }

    public String getLid_photo() {
        return lid_photo;
    }

    public void setLid_photo(String lid_photo) {
        this.lid_photo = lid_photo;
    }

    @Override
    public String toString() {
        return "Luser{" +
                "l_id=" + l_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", rid_photo='" + rid_photo + '\'' +
                ", lid_photo='" + lid_photo + '\'' +
                '}';
    }
}
