package com.nsu.dao;

import com.nsu.domain.Activity;
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
}
