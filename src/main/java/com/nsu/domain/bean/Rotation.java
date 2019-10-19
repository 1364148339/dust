package com.nsu.domain.bean;

/**
 * 内容：
 * 轮播图
 * @author: wangqiao
 * @time: 2019/10/11
 */
public class Rotation {

    private Long id;
    private String url;//地址
    private String tourl;//链接
    private String city;//城市

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTourl() {
        return tourl;
    }

    public void setTourl(String tourl) {
        this.tourl = tourl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Rotation{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", tourl='" + tourl + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
