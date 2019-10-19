package com.nsu.service;

import com.nsu.domain.bean.User;
import org.springframework.stereotype.Service;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/9/27
 */
@Service("userService")
public interface UserService {

    /**
     * 通过手机号进行登陆
     * @param user
     * @return
     */
    User phoneLogin(User user);

    /**
     * 通过邮箱登陆
     * @param user
     * @return
     */
    Boolean emailLogin(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    String register(User user);

    /**
     * 判断是否存在这个手机号
     * @param user
     * @return
     */
    Boolean checkPhoneNumber(User user);


    /**
     * 判断是否存在该邮箱
     * @param user
     * @return
     */
    Boolean checkEmail(User user);

    /**
     * 手机号重置密码
     *
     */
    String phoneUpdatePassword(User user);

    /**
     *通过id获取user信息
     *
     */
    User findById(User user);

    /**
     * 更换头像
     * @param user
     */
    void updatePhoto(User user);

    /**
     * 修改昵称
     * @param user
     */
    void updateName(User user);

    /**
     * 修改签名
     * @param user
     */
    void updateAutograph(User user);
}
