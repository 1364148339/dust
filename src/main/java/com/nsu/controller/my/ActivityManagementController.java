package com.nsu.controller.my;

import com.nsu.domain.Activity_Check;
import com.nsu.domain.Check;
import com.nsu.domain.bean.Activity;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.Activity_CheckService;
import com.nsu.service.Activity_VolunteerService;
import com.nsu.service.VolunteerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容：
 * 我的活动
 * @author: wangqiao
 * @time: 2019/10/9
 */
@Controller
@RequestMapping("/myActivity")
@Api(tags="ActivityManagementController",description="活动信息")
public class ActivityManagementController {

    @Autowired
    private Activity_VolunteerService activity_VolunteerService;
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private Activity_CheckService activity_CheckService;

    /**
     * 得到志愿者参加的所有活动
     * @param user  活动id  志愿者id
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:得到志愿者参加的所有活动",notes="接口说明：需要UserId")
    @RequestMapping("/getVolunteerAct")
    public @ResponseBody
    List<Activity> getVolunteerAct(@RequestBody User user)
    {
        //1.通过用户id 查到志愿者id
        Volunteer volunteer = volunteerService.findByUserId( user );
        //2.再查到它所对应的活动编号
        List<Activity> list = activity_VolunteerService.findByV_id(volunteer );
        //if(list.size()<=0) return new ArrayList<Activity>(  );
        return list;
    }

    /**
     * 发起活动签到
     * @param activity_check
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:发起活动签到",notes="接口说明：需要Activity_Check")
    @RequestMapping("/initiateSignIn")
    public String initiateSignIn(Activity_Check activity_check)
    {
        activity_CheckService.initiateActivityCheck( activity_check );
        return "success";
    }

    /**
     * 获取签到状态
     * @param activity
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:获取签到状态",notes="接口说明：需要活动id")
    @RequestMapping("/getActivityStatus")
    public @ResponseBody String getActivityStatus(@RequestBody Activity activity)
    {
        return activity_CheckService.findStatus( activity );
    }

    /**
     * 志愿者活动签到
     * @param check
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:志愿者活动签到",notes="接口说明：需要Check")
    @RequestMapping("/goSignIn")
    public @ResponseBody String goSignIn(@RequestBody Check check)
    {
        Activity activity = new Activity();
        activity.setA_id( check.getA_id() );
        String res = activity_CheckService.findStatus( activity );
        if("0".equals( res )) return "0";
        if(activity_CheckService.checkIn( check )) return "1";
        return "0";
    }

}
