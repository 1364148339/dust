package com.nsu.service;

import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.InfoActivity;
import com.nsu.domain.bean.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/3
 */
@Service("activityService")
public interface ActivityService {

    /**
     * 通过活动id,查找活动
     * @param activity
     * @return
     */
    InfoActivity findById(Activity activity);

    /**
     * 查找全部活动
     * @return
     */
    List<Activity> findAll();

    /**
     * 查找同城活动
     */
    List<Activity> findByCity(Activity activity);

    /**
     * 查找该类型的活动
     */
    List<Activity> findByType(Activity activity);

    /**
     *参加活动
     */
    void joinActivity(Activity_Volunteer activity_volunteer);
}
