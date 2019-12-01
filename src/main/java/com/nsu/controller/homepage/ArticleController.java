package com.nsu.controller.homepage;

import com.nsu.domain.bean.H_man;
import com.nsu.service.H_manService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容：
 * 显示文章
 * @author: wangqiao
 * @time: 2019/10/23
 */
@Controller
@RequestMapping("/home")
@Api(tags="ArticleController",description="首页显示文章")
public class ArticleController {

    @Autowired
    private H_manService h_manService;
    /**
     * @param index 数量 15条
     * @return 受助者信息 包含文章
     */
    @ApiOperation(httpMethod="POST",value="接口标题:返回15条文章信息",notes="接口说明：需要String index")
    @RequestMapping("/getArticle")
    public @ResponseBody List<H_man> getArticle(String index)
    {
        try {
            Long num = new Long( index );
            List<H_man> list = h_manService.findBySection( num-15,num );
            return list;
        }catch (NumberFormatException n)
        {
            //如果index不是纯数据 会出异常 那么返回空值
            return null;
        }
    }
}
