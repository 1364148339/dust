package com.nsu.controller.microLove;

import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.InfoActivity;
import com.nsu.domain.bean.Activity;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.ActivityService;
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
 * 活动信息
 * @author: wangqiao
 * @time: 2019/10/4
 */
@Controller
@RequestMapping("/activity")
@Api(tags="ActivityController",description="活动信息")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private Activity_VolunteerService activity_VolunteerService;
    @Autowired
    private VolunteerService volunteerService;


    /**
     * 通过活动编号 显示活动页面
     * @param activity
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:通过活动编号,查到活动所有数据",notes="接口说明：需要Activity编号")
    @RequestMapping("/getInfoActivity")
    public @ResponseBody InfoActivity getById(@RequestBody Activity activity)
    {
        InfoActivity act = activityService.findById( activity );
        return act;
    }

    /**
     * 得到同城活动列表--要求在当前时间在开始时间和结束时间内
     * @return
     */
    @ApiOperation(httpMethod="POST",value="得到同城活动列表",notes="接口说明：需要Activity的省份和城市")
    @RequestMapping("/getByCity")
    public @ResponseBody List<Activity> getByCity(@RequestBody Activity activity)
    {
        List<Activity> list = activityService.findByCity(activity);
        return list;
    }

    /**
     * 得到该类型的活动列表--要求在当前时间在开始时间和结束时间内
     * @return
     */
    @ApiOperation(httpMethod="POST",value="得到该类型的活动列表",notes="接口说明：需要Activity的类型")
    @RequestMapping("/getByType")
    public @ResponseBody List<Activity> getByType(@RequestBody Activity activity)
    {
        List<Activity> list = activityService.findByType( activity );
        return list;
    }

    /**
     * 参加活动
     * @param activity_volunteer  活动id  用户id-->查询v_id
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:参加活动",notes="接口说明：需要Activity_Volunteer的活动id和志愿者id")
    @RequestMapping("/joinActivity")
    public @ResponseBody String joinActivity(@RequestBody Activity_Volunteer activity_volunteer)
    {
        User user = new User();
        user.setId( activity_volunteer.getV_id() );
        Volunteer volunteer = volunteerService.findByUserId( user );
        activity_volunteer.setV_id( volunteer.getV_id() );
        //判断志愿者是否参加过此活动
        //如果没有参加
        if(!activity_VolunteerService.checkVolunteer( activity_volunteer ))
        {
            activityService.joinActivity( activity_volunteer );
            return "1";
        }
        return "0";
    }

}
