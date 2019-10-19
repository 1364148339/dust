package com.nsu.domain;

/**
 * 内容：
 * 捐助信息
 * @author: wangqiao
 * @time: 2019/10/9
 */
public class Donation_info {

    private Long d_id;    //捐助编号
    private Long h_id;    //受助人id
    private Long id;      //用户id
    private Long i_id;    //物品id

    public Long getD_id() {
        return d_id;
    }

    public void setD_id(Long d_id) {
        this.d_id = d_id;
    }

    public Long getH_id() {
        return h_id;
    }

    public void setH_id(Long h_id) {
        this.h_id = h_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getI_id() {
        return i_id;
    }

    public void setI_id(Long i_id) {
        this.i_id = i_id;
    }

    @Override
    public String toString() {
        return "Donation_info{" +
                "d_id=" + d_id +
                ", h_id=" + h_id +
                ", id=" + id +
                ", i_id=" + i_id +
                '}';
    }
}
