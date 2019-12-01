package com.nsu.domain;

/**
 * 内容：
 * 志愿者签到
 * @author: wangqiao
 * @time: 2019/11/17
 */
public class Check {
    //活动id
    private Long a_id;
    //用户id 或志愿者id
    private Long id;
    //签到码
    private String check_num;
    //位置信息
    private String position_info;

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheck_num() {
        return check_num;
    }

    public void setCheck_num(String check_num) {
        this.check_num = check_num;
    }

    public String getPosition_info() {
        return position_info;
    }

    public void setPosition_info(String position_info) {
        this.position_info = position_info;
    }
}
