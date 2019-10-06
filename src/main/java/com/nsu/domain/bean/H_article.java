package com.nsu.domain.bean;



/**
 * 内容：
 * 志愿者发布的文章
 * @author: wangqiao
 * @time: 2019/10/6
 */
public class H_article {
    private Long a_id;                 //文章编号：a_id
    private String title;              //标题：title
    private String w_article;          //文字：w_article
    private String g_photo;            //图片：g_photo

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getW_article() {
        return w_article;
    }

    public void setW_article(String w_article) {
        this.w_article = w_article;
    }

    public String getG_photo() {
        return g_photo;
    }

    public void setG_photo(String g_photo) {
        this.g_photo = g_photo;
    }

    @Override
    public String toString() {
        return "H_article{" +
                "a_id=" + a_id +
                ", title='" + title + '\'' +
                ", w_article='" + w_article + '\'' +
                ", g_photo='" + g_photo + '\'' +
                '}';
    }
}
