package com.nsu.dao;


import com.nsu.domain.bean.Activity;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.bean.Volunteer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/3
 */
public interface Activity_VolunteerDao {

    /**
     * 通过活动id  查找志愿者id
     * @param activity_volunteer
     * @return
     */
    @Select( "select * from Activity_#{a_id}" )
    List<Activity_Volunteer> findByA_id(Activity_Volunteer activity_volunteer);

    /**
     * 通过志愿者id  查找对应的活动
     * @param volunteer
     * @return
     */
    @Select( "SELECT * FROM Activity WHERE a_id  in\n" +
            "(\n" +
            "   select a_id from Volunteer_#{v_id}\n" +
            ")" )
    List<Activity> findByV_id(Volunteer volunteer);
}
