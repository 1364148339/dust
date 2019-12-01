package com.nsu.controller.homepage;


import com.nsu.service.H_manService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容：
 * 热力图
 * @author: wangqiao
 * @time: 2019/11/18
 */
@Component
@RequestMapping("/home")
@Api(tags="ThermalMapController",description="热力图")
public class ThermalMapController {
    @Autowired
    private H_manService h_manService;

    /**
     * 查询孩子的位置 省市区
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:查询孩子的位置 省市区",notes="接口说明：null")
    @RequestMapping("/getPosition")
    public @ResponseBody
    List<String> getPosition()
    {
        return h_manService.findByAllPosition();
    }
}
