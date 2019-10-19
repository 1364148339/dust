package com.nsu.domain.bean;

/**
 * 内容：
 * 受助人
 * @author: wangqiao
 * @time: 2019/10/15
 */
public class H_man {

    private Long h_id;  //编号
    private String name; //姓名
    private String sex;  //性别
    private Integer age;  //年龄
    private String star;  //星座
    private String b_day; //生日
    private String photo; //照片
    private String h_type; //受助类型
    private String province;//省
    private String city; //市
    private String address; //地址
    private String introduce; //简介
    private String state;//审核状态
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getH_id() {
        return h_id;
    }

    public void setH_id(Long h_id) {
        this.h_id = h_id;
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getB_day() {
        return b_day;
    }

    public void setB_day(String b_day) {
        this.b_day = b_day;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getH_type() {
        return h_type;
    }

    public void setH_type(String h_type) {
        this.h_type = h_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "H_man{" +
                "h_id=" + h_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", star='" + star + '\'' +
                ", b_day='" + b_day + '\'' +
                ", photo='" + photo + '\'' +
                ", h_type='" + h_type + '\'' +
                ", address='" + address + '\'' +
                ", introduce='" + introduce + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
