package com.nsu.service;

import com.nsu.domain.bean.Relation;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/3
 */
@Service("volunteerService")
public interface VolunteerService {

    /**
     * 查找所有志愿者
     * @return
     */
    List<Volunteer> findAll();

    /**
     * 通过志愿者编号查找志愿者
     * @param volunteer 志愿者编号
     * @return
     */
    Volunteer findById(Volunteer volunteer);

    /**
     * 通过用户id 查询 志愿者id
     * @param user
     * @return
     */
    Volunteer findByUserId(User user);

    /**
     * 志愿者认证
     * @param volunteer 志愿者全部信息
     */
    void addAuthentication(Volunteer volunteer);

    /**
     * 添加结对
     *
     */
    void addPair(Relation relation);
}
