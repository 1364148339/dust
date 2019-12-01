package com.nsu.service;

import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    Boolean addAuthentication(Volunteer volunteer,MultipartFile[] uploads,String path) throws IOException;

    /**
     * 添加结对
     * @param h_man  受助人
     * @param volunteer 志愿者
     * @param uploads 受助人照片+文章图片
     */
    Boolean addPair(H_man h_man, Volunteer volunteer, MultipartFile[] uploads,String path) throws IOException;

    /**
     *参加活动
     */
    void joinActivity(Activity_Volunteer activity_volunteer);
}

