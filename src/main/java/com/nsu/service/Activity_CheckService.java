package com.nsu.service;

import com.nsu.domain.Activity_Check;
import com.nsu.domain.Check;
import com.nsu.domain.bean.Activity;
import org.springframework.stereotype.Service;


/**
 * 内容：
 * 签到
 * @author: wangqiao
 * @time: 2019/11/17
 */
@Service("activity_CheckService")
public interface Activity_CheckService {
    /**
     * 发起签到
     * @param activity_check
     */
    void initiateActivityCheck(Activity_Check activity_check);

    /**
     * 获取最低下的签到的状态
     * @param activity 活动id
     * @return
     */
    String findStatus(Activity activity);

    /**
     * 志愿者签到
     * @param check
     */
    Boolean checkIn(Check check);
}
