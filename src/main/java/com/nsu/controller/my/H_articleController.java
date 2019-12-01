package com.nsu.controller.my;

import com.nsu.domain.bean.H_article;
import com.nsu.service.H_articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 内容：
 * 首页--文章展示
 * @author: wangqiao
 * @time: 2019/10/6
 */
@Controller
@RequestMapping("/home")
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
    public H_article getH_article(H_article h_article)
    {
        H_article h = h_articleService.findById( h_article);
        return h;
    }


}
