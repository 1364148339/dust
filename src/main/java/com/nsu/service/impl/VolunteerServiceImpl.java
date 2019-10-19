package com.nsu.service.impl;

import com.nsu.dao.bean.VolunteerDao;
import com.nsu.domain.bean.Relation;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("volunteerServiceImpl")
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired @Qualifier("volunteerDao")
    private VolunteerDao volunteerDao;
    /**
     * 查询所有志愿者
     * @return
     */
    @Override
    public List<Volunteer> findAll() {
        return null;
    }

    /**
     * 通过编号查询志愿者
     * @param volunteer 志愿者编号
     * @return
     */
    @Override
    public Volunteer findById(Volunteer volunteer) {
        return null;
    }

    /**
     * 通过用户编号查询志愿者
     * @param user
     * @return
     */
    @Override
    public Volunteer findByUserId(User user) {
        return volunteerDao.findByUserId( user );
    }


    /**
     * 志愿者认证
     * @param volunteer 志愿者全部信息
     */
    @Override
    public void addAuthentication(Volunteer volunteer) {
       volunteerDao.authentication( volunteer );
    }

    /**
     * 添加结对
     * @param relation
     */
    @Override
    public void addPair(Relation relation) {
        volunteerDao.addPair( relation );
    }
}
