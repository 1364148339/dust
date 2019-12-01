package com.nsu.domain;

/**
 * 内容：
 * 签到
 * @author: wangqiao
 * @time: 2019/11/17
 */
public class Activity_Check {
    private Long a_id;             //活动id
    private Integer check_id;      //签到id
    private String check_num;      //签到码
    private String continued_time; //签到持续时间
    private String check_status;   //签到状态

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public Integer getCheck_id() {
        return check_id;
    }

    public void setCheck_id(Integer check_id) {
        this.check_id = check_id;
    }

    public String getCheck_num() {
        return check_num;
    }

    public void setCheck_num(String check_num) {
        this.check_num = check_num;
    }

    public String getContinued_time() {
        return continued_time;
    }

    public void setContinued_time(String continued_time) {
        this.continued_time = continued_time;
    }

    public String getCheck_status() {
        return check_status;
    }

    public void setCheck_status(String check_status) {
        this.check_status = check_status;
    }

    @Override
    public String toString() {
        return "Activity_Check{" +
                "a_id=" + a_id +
                ", check_id=" + check_id +
                ", check_num='" + check_num + '\'' +
                ", continued_time='" + continued_time + '\'' +
                ", check_status='" + check_status + '\'' +
                '}';
    }
}
