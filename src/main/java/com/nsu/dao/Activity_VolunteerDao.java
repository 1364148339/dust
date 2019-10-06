package com.nsu.dao;


import com.nsu.domain.Activity_Volunteer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/3
 */
@Repository("activity_VolunteerDao")
public interface Activity_VolunteerDao {

    /**
     * 通过活动id  查找志愿者id
     * @param activity_volunteer
     * @return
     */
    @Select( "select * from Activity_#{a_id}" )
    List<Activity_Volunteer> findByA_id(Activity_Volunteer activity_volunteer);

    /**
     * 通过志愿者id  查找活动id
     * @param activity_volunteer
     * @return
     */
    @Select( "select * from Volunteer_#{v_id}" )
    List<Activity_Volunteer> findByV_id(Activity_Volunteer activity_volunteer);
}
