package com.nsu.controller.homepage;

import com.nsu.domain.bean.Rotation;
import com.nsu.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容：
 * 轮播图
 * @author: wangqiao
 * @time: 2019/10/11
 */
@Component
@RequestMapping("/home")
public class RotationController {
    @Autowired
    private RotationService rotationService;

    /**
     * 查找对应城市的轮播图
     * @param rotation
     * @return
     */
    @RequestMapping("/getRotation")
    public @ResponseBody List<Rotation> getRotation(@RequestBody Rotation rotation)
    {
        return rotationService.findAll(rotation);
    }
}
