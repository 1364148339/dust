package com.nsu.service.impl;

import com.nsu.dao.ActivityDao;
import com.nsu.domain.Activity;
import com.nsu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/3
 */
@Service("activityServiceImpl")
public class ActivityServiceImpl implements ActivityService {


    @Autowired @Qualifier("activityDao")
    private ActivityDao activityDao;
    /**
     * 通过活动id,查找活动
     * @param activity id
     * @return
     */
    @Override
    public Activity findById(Activity activity) {
        Activity act = activityDao.findById( activity );
        return act;
    }

    /**
     * 查找全部活动
     * @return
     */
    @Override
    public List<Activity> findAll() {
        List<Activity> list = activityDao.findAll();
        return list;
    }
}
