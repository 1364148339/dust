package com.nsu.service;

import com.nsu.domain.User;
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
    Boolean mailLogin(User user);

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
    Boolean findPhoneNumber(User user);


    /**
     * 判断是否存在该邮箱
     * @param user
     * @return
     */
    Boolean findMailbox(User user);

    /**
     * 手机号重置密码
     *
     */
    void phoneFindPassword(User user);
}
