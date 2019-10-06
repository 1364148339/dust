package com.nsu.controller.Article;

import com.nsu.domain.bean.H_article;
import com.nsu.service.H_articleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 内容：
 * 志愿者的文章
 * @author: wangqiao
 * @time: 2019/10/6
 */
public class H_articleController {

    @Autowired
    private H_articleService h_articleService;
    //获取文章列表
    public List<H_article> getAll()
    {
        List<H_article> list = h_articleService.findAll();
        return list;
    }
    //通过id查询文章

    // 上传文章
}
