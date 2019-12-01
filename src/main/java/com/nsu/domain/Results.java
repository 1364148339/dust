package com.nsu.domain;

/**
 * 内容：
 * 后台表格接收的数据类型
 * @author: wangqiao
 * @time: 2019/11/19
 */
public class Results<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体数据
    private Object data;
    //查询数量
    private Long count;

    public Results()
    {
        super();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
