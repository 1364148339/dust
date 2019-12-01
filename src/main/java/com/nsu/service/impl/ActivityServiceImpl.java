package com.nsu.service.impl;

import com.nsu.dao.bean.ActivityDao;
import com.nsu.dao.bean.VolunteerDao;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.InfoActivity;
import com.nsu.dao.bean.WelfareDao;
import com.nsu.domain.bean.Activity;
import com.nsu.domain.bean.Welfare;
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
    @Autowired @Qualifier("volunteerDao")
    private VolunteerDao volunteerDao;
    @Autowired@Qualifier("welfareDao")
    private WelfareDao welfareDao;
    /**
     * 通过活动id,查找活动
     *
     * 把信息匹配上去
     * @param activity id
     * @return
     */
    @Override
    public InfoActivity findById(Activity activity) {

        Activity act = activityDao.findById( activity );
        InfoActivity infoActivity = new InfoActivity();
        //信息导入
        infoActivity.setClaim( act.getClaim() );
        infoActivity.setIntroduce( act.getB_introduce() );
        //组织名称
        Welfare welfare = new Welfare();
        welfare.setO_id( act.getO_id() );
        Welfare welfare1 = welfareDao.findById( welfare );
        infoActivity.setName( welfare1.getName() );

        infoActivity.setNumber( act.getNumber() );
        infoActivity.setPhone( act.getPhone() );
        //地名  省+市+区+具体地址
        infoActivity.setPlace( act.getProvince()+act.getCity()+act.getArea()+act.getPlace() );

        infoActivity.setPrincipal( act.getPrincipal() );
        //时间  开始时间-结束时间
        infoActivity.setTime( act.getS_time()+" - "+act.getE_time() );
        infoActivity.setTitle( act.getTitle() );
        infoActivity.setPhoto( act.getG_photo() );
        infoActivity.setType( act.getType() );
        return infoActivity;
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

    /**
     * 查找同城活动
     * @param activity
     * @return
     */
    @Override
    public List<Activity> findByCity(Activity activity) {
        List<Activity> list = activityDao.findByCity( activity );
        return list;
    }

    /**
     * 查找该类型的活动
     * @param activity
     * @return
     */
    @Override
    public List<Activity> findByType(Activity activity) {
        List<Activity> list = activityDao.findByType( activity );
        return list;
    }

    /**
     * 参加活动
     * @param activity_volunteer 活动id+志愿者id
     */
    @Override
    public void joinActivity(Activity_Volunteer activity_volunteer) {
        activityDao.joinActivity( activity_volunteer );
        volunteerDao.joinActivity( activity_volunteer );
    }


}
