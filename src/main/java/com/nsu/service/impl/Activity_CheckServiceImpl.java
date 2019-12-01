package com.nsu.service.impl;

import com.nsu.dao.Activity_CheckDao;
import com.nsu.dao.Activity_VolunteerDao;
import com.nsu.dao.bean.VolunteerDao;
import com.nsu.domain.Activity_Check;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.Check;
import com.nsu.domain.bean.Activity;
import com.nsu.domain.bean.User;
import com.nsu.service.Activity_CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/11/17
 */
@Service("activity_CheckServiceImpl")
public class Activity_CheckServiceImpl implements Activity_CheckService {
    @Autowired
    private Activity_CheckDao activity_checkDao;
    @Autowired
    private Activity_VolunteerDao activity_volunteerDao;
    @Autowired
    private VolunteerDao volunteerDao;

    /**
     * 发起签到
     * @param activity_check
     */
    @Override
    public void initiateActivityCheck(Activity_Check activity_check) {
        //1.往活动签到表中插入签到 并且返回签到id
        activity_checkDao.initiateSignIn( activity_check );
        //表名
        String tableName = "Activity_Check_"+activity_check.getA_id().toString()+"_"+activity_check.getCheck_id().toString();
        //2.创建子签到表
        activity_checkDao.creatCheckInForm( tableName );
        //3.获取参加该活动的所有志愿者id
        Activity_Volunteer activity_volunteer = new Activity_Volunteer();
        activity_volunteer.setA_id( activity_check.getA_id() );
        List<Activity_Volunteer> list = activity_volunteerDao.findByA_id( activity_volunteer );
        activity_checkDao.importVolunteers( list,tableName );
        //4.开起一个定时线程 到了时间就将签到状态设置为"0"
        new Thread(){
            public void run()
            {
                Activity_Check check = activity_check;
                //表名
                String tableName = "Activity_Check_"+check.getA_id().toString();
                //签到id
                //时间单位  分
                Integer time = Integer.valueOf( check.getContinued_time() ) ;
                try {
                    //睡眠
                    Thread.sleep( time*60*1000 );
                    //修改签到状态
                    activity_checkDao.modifyCheckInStatus( tableName,check.getCheck_id());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * 返回最低下签到的状态
     * @param activity 活动id
     * @return
     */
    @Override
    public String findStatus(Activity activity) {
        String status = activity_checkDao.findStatus( activity );
        if(status==null) return "0";
        return status;
    }

    /**
     * 志愿者签到
     * @param check
     */
    @Override
    public Boolean checkIn(Check check) {
        //1.将check中的用户id  替换为志愿者id
        User user = new User();
        user.setId( check.getId() );
        Long v_id = volunteerDao.UidFindByUserId( user );
        check.setId( v_id );
        //2.查询check_id
        Activity activity = new Activity();
        activity.setA_id( check.getA_id() );
        Integer check_id = activity_checkDao.findCheckId( activity );
        //3.查询check_num签到码
        String check_num = activity_checkDao.findCheckNum( activity );
        //4.对比签到码
        if(check.getCheck_num().equals( check_num ))
        {
            //5.导入信息
            String tableName = "Activity_Check_"+check.getA_id().toString()+"_"+check_id.toString();
            activity_checkDao.checkIn( tableName,check );
            return true;
        }
        return false;
    }


}
