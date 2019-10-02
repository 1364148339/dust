package com.nsu.service.bean.impl;

import com.nsu.dao.bean.UserDao;
import com.nsu.domain.bean.User;
import com.nsu.service.bean.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/9/27
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired@Qualifier("userDao")
    private UserDao userDao;

    /**
     * 通过手机号进行登陆---手机号，密码
     * @param user
     * @return
     */
    @Override
    public Boolean phoneLogin(User user) {
        String password = userDao.findPhonePassword( user );
        if(password==null) return false;
        if(password.equals( user.getPwd() )) return true;
        return false;
    }

    /**
     * 通过邮箱登陆---邮箱，密码
     * @param user
     * @return
     */
    @Override
    public Boolean emailLogin(User user) {
        String password = userDao.findEmailPassword( user );
        if(password==null) return false;
        if(password.equals( user.getPwd() )) return true;
        return false;
    }

    /**
     * 注册---手机号，昵称，邮箱，密码
     * @param user
     * @return
     */
    @Override
    public void register(User user)
    {
       userDao.addUser( user );
    }

    /**
     * 判断是否存在这个手机号---手机号
     * @param user
     * @return
     */
    @Override
    public Boolean checkPhoneNumber(User user)
    {
        Object oj = userDao.findPhoneNumber( user );
        if(oj!=null) return true;
        else return false;
    }

    /**
     * 判断是否存在该邮箱---邮箱
     * @param user
     * @return
     */
    @Override
    public Boolean checkEmail(User user)
    {
        Object oj = userDao.findEmail( user );
        if(oj!=null) return true;
        else return false;
    }

    /**
     * 修改密码---手机号和重置后的密码
     * @param user
     * @return
     */
    @Override
    public void phoneUpdatePassword(User user) {
        userDao.updatePassword(user);
    }
}
