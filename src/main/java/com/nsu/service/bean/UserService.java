package com.nsu.service.bean;

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
    Boolean phoneLogin(User user);

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
    void register(User user);

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
    void phoneUpdatePassword(User user);
}
