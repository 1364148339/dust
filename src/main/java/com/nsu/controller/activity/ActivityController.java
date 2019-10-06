package com.nsu.controller.activity;

import com.nsu.domain.Activity;
import com.nsu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/4
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 通过活动编号 查到活动所有数据
     * @param activity
     * @return
     */
    @RequestMapping("/getActivity")
    public @ResponseBody Activity getActivity(@RequestBody Activity activity)
    {
        Activity act = activityService.findById( activity );
        return act;
    }

    /**
     * 得到所有的活动列表
     * @return
     */
    @RequestMapping("/getAll")
    public @ResponseBody List<Activity> getAll()
    {
        List<Activity> list = activityService.findAll();
        return list;
    }
}
