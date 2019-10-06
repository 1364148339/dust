package com.nsu.controller.activity;


import com.nsu.domain.Activity_Volunteer;
import com.nsu.service.Activity_VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/3
 */
@Controller
@RequestMapping("/activity")
public class CheckActivityController {

    @Autowired
    private Activity_VolunteerService activity_VolunteerService;

    /**
     * 判断志愿者是否参加了此活动
     * @param activity_volunteer  活动id  志愿者id
     * @return
     */
    @RequestMapping("/checkVolunteer")
    public @ResponseBody String checkVolunteer(@RequestBody Activity_Volunteer activity_volunteer)
    {
       if(activity_VolunteerService.checkVolunteer( activity_volunteer )) return "1";
       return "0";
    }
}
