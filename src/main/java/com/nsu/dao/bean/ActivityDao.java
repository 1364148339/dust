package com.nsu.dao.bean;

import com.nsu.domain.bean.Activity;
import com.nsu.domain.Activity_Volunteer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 * 志愿者招募活动:Activity
 * @author: wangqiao
 * @time: 2019/10/3
 */
@Repository("activityDao")
public interface ActivityDao {

    /**
     * 通过活动id,查找活动
     * @param activity
     * @return
     */
    @Select( "select * from Activity where a_id = #{a_id}" )
    Activity findById(Activity activity);

    /**
     * 查找全部活动
     * @return
     */
    @Select( "select * from Activity" )
    List<Activity> findAll();

    /**
     * 查找同城活动
     * and s_time < CURRENT_DATE and e_time > CURRENT_DATE
     */
    @Select( "select a_id,title,g_photo from Activity where province=#{province} and city=#{city}" )
    List<Activity> findByCity(Activity activity);

    /**
     * 根据活动类型查询
     */
    @Select( "select * from Activity where type=#{type}" )
    List<Activity> findByType(Activity activity);

    /**
     * 参加活动
     * @param activity_volunteer
     */
    @Insert("INSERT INTO Activity_#{a_id} VALUES (#{a_id},#{v_id})")
    void joinActivity(Activity_Volunteer activity_volunteer);

}
