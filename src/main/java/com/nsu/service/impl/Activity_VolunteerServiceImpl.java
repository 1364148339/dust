package com.nsu.service.impl;

import com.nsu.dao.Activity_VolunteerDao;
import com.nsu.domain.bean.Activity;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.Activity_VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/4
 */
@Service("activity_VolunteerServiceImpl")
public class Activity_VolunteerServiceImpl implements Activity_VolunteerService {


    @Autowired @Qualifier("activity_VolunteerDao")
    private Activity_VolunteerDao activity_VolunteerDao;

    @Override
    public List<Activity_Volunteer> findByA_id(Activity_Volunteer activity_volunteer) {
        List<Activity_Volunteer> list = activity_VolunteerDao.findByA_id( activity_volunteer );
        return list;
    }

    @Override
    public List<Activity> findByV_id(Volunteer volunteer) {
        List<Activity> list = activity_VolunteerDao.findByV_id(volunteer );
        return list;
    }

    @Override
    public Boolean checkVolunteer (Activity_Volunteer activity_volunteer) {
        Volunteer volunteer = new Volunteer();
        volunteer.setV_id( activity_volunteer.getV_id() );
        //得到志愿者参与活动的集合
        List<Activity> list = this.findByV_id(volunteer);
        for(Activity act:list)
        {

            //如果有出现相同的活动id  则证明参与了该活动
            if(act.getA_id()==activity_volunteer.getA_id())
            {
                return true;
            }
        }
        return false;
    }
}
