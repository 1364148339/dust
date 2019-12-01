package com.nsu.domain.bean;

import java.io.Serializable;

/**
 * 内容：
 * 志愿者:Volunteer
 * @author: wangqiao
 * @time: 2019/10/2
 */
public class Volunteer implements Serializable {

    private Long v_id;            //志愿者编号
    private Long id;              //用户编号
    private String name;          //姓名
    private String sex;           //性别
    private Integer age;          //年龄
    private String province;      //省份
    private String city;          //城市
    private String address;       //地址
    private String rid_photo;     //身份证照片正面url
    private String lid_photo;     //身份证照片反面url
    private String ff_photo;      //正面照：ff_photo
    private Long o_id;            //组织编号：o_id
    private String area;          //区

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return "Volunteer{" +
                "v_id=" + v_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", rid_photo='" + rid_photo + '\'' +
                ", lid_photo='" + lid_photo + '\'' +
                ", ff_photo='" + ff_photo + '\'' +
                ", o_id=" + o_id +
                '}';
    }

    public Long getV_id() {
        return v_id;
    }

    public void setV_id(Long v_id) {
        this.v_id = v_id;
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

    public String getFf_photo() {
        return ff_photo;
    }

    public void setFf_photo(String ff_photo) {
        this.ff_photo = ff_photo;
    }

    public Long getO_id() {
        return o_id;
    }

    public void setO_id(Long o_id) {
        this.o_id = o_id;
    }
}
