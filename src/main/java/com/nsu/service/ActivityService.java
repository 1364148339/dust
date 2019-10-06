package com.nsu.service;

import com.nsu.domain.Activity;
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
    Activity findById(Activity activity);

    /**
     * 查找全部活动
     * @return
     */
    List<Activity> findAll();
}
