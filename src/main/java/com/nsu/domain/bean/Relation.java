package com.nsu.domain.bean;

/**
 * 内容：
 * 结对
 * @author: wangqiao
 * @time: 2019/10/16
 */
public class Relation {

    private Long r_id; //结对编号
    private Long v_id;  //志愿者编号
    private Long o_id;  //组织id
    private String up_time; //上传时间
    private Long h_id;  //受助人id
    private String handle_time;//处理时间
    private String state;//审核状态

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getO_id() {
        return o_id;
    }

    public void setO_id(Long o_id) {
        this.o_id = o_id;
    }
    public Long getR_id() {
        return r_id;
    }

    public void setR_id(Long r_id) {
        this.r_id = r_id;
    }

    public Long getV_id() {
        return v_id;
    }

    public void setV_id(Long v_id) {
        this.v_id = v_id;
    }

    public String getUp_time() {
        return up_time;
    }

    public void setUp_time(String up_time) {
        this.up_time = up_time;
    }

    public Long getH_id() {
        return h_id;
    }

    public void setH_id(Long h_id) {
        this.h_id = h_id;
    }

    public String getHandle_time() {
        return handle_time;
    }

    public void setHandle_time(String handle_time) {
        this.handle_time = handle_time;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "r_id=" + r_id +
                ", v_id=" + v_id +
                ", o_id=" + o_id +
                ", up_time='" + up_time + '\'' +
                ", h_id=" + h_id +
                ", handle_time='" + handle_time + '\'' +
                '}';
    }
}
