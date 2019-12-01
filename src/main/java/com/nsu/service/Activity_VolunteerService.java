package com.nsu.service;


import com.nsu.domain.bean.Activity;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.bean.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/4
 */
@Service("activity_VolunteerService")
public interface Activity_VolunteerService {
    /**
     * 通过活动id  查找志愿者id
     * @param activity_volunteer
     * @return
     */
    List<Activity_Volunteer> findByA_id(Activity_Volunteer activity_volunteer);

    /**
     * 通过志愿者id  查找活动id
     * @param volunteer
     * @return
     */
    List<Activity> findByV_id(Volunteer volunteer);


    /**
     * 查看改志愿者有没有参加该活动
     * @param activity_volunteer
     * @return
     */
    Boolean checkVolunteer(Activity_Volunteer activity_volunteer);
}
