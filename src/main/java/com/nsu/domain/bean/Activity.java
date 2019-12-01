package com.nsu.domain.bean;

import java.io.Serializable;

/**
 * 内容：
 * 组织发布的志愿者招募活动
 * @author: wangqiao
 * @time: 2019/10/3
 */
public class Activity implements Serializable {

    private Long a_id;            //编号
    private Long o_id;            //公益组织编号
    private String title;         //标题
    private String b_introduce;    //简介
    private String s_time;        //开始时间
    private String e_time;        //结束时间
    private String province;      //省份
    private String city;          //城市
    private String area;          //区
    private String place;         //地点
    private String g_photo;       //图片
    private Integer number;       //招募人数
    private String state;         //审核状态
    private String type;          //活动类型
    private String participants;  //以招募人数
    private String principal;     //负责人
    private String phone;         //联系电话
    private String claim;         //报名要求

    public String getClaim() {
        return claim;
    }
    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public Long getO_id() {
        return o_id;
    }

    public void setO_id(Long o_id) {
        this.o_id = o_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getB_introduce() {
        return b_introduce;
    }

    public void setB_introduce(String b_introduc) {
        this.b_introduce = b_introduc;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getG_photo() {
        return g_photo;
    }

    public void setG_photo(String g_photo) {
        this.g_photo = g_photo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "a_id=" + a_id +
                ", o_id=" + o_id +
                ", title='" + title + '\'' +
                ", b_introduc='" + b_introduce + '\'' +
                ", s_time='" + s_time + '\'' +
                ", e_time='" + e_time + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", place='" + place + '\'' +
                ", g_photo='" + g_photo + '\'' +
                ", number=" + number +
                ", state='" + state + '\'' +
                '}';
    }
}
