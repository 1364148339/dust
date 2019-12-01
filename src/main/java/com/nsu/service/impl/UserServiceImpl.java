package com.nsu.service.impl;

import com.nsu.dao.bean.UserDao;
import com.nsu.domain.bean.User;
import com.nsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        if(list.size()<=0) return new ArrayList<>(  );
        return list;
    }

    @Override
    public List<User> searchAll(String key) {
        List<User> list = userDao.searchAll( "%"+key+"%" );
        if(list==null || list.size()<=0) return new ArrayList<>(  );
        return list;
    }

    /**
     * 通过手机号进行登陆---手机号，密码
     * @param user
     * @return
     */
    @Override
    public User phoneLogin(User user) {
       User u = userDao.findPhonePassword( user );
       if(u==null)
       {
           return new User();
       }
       return u;
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
    public String register(User user)
    {
        //1.判断手机号是否存在
        if(checkPhoneNumber( user )) return "-1";
        //2.判断邮箱号是否存在
        if(checkEmail( user )) return "-2";
        userDao.addUser( user );
        return "1";
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
    public String phoneUpdatePassword(User user) {
        //判断是否有这手机号
        if(!checkPhoneNumber( user )) return "0";
        userDao.updatePassword(user); return "1";
    }

    /**
     * 通过id 获取user消息
     * @param user
     * @return
     */
    @Override
    public User findById(User user) {
        User u = userDao.findById( user );
        return u;
    }


    /**
     * 更换头像
     * @param user
     */
    @Override
    public void updatePhoto(User user) {
        userDao.updatePhoto( user );
    }

    /**
     * 更换昵称
     * @param user
     */
    @Override
    public void updateName(User user) {
        userDao.updateName( user );
    }

    /**
     * 更换签名
     * @param user
     */
    @Override
    public void updateAutograph(User user) {
       userDao.updateAutograph( user );
    }

    /**
     * 增加积分
     * @param user
     * @param integral
     */
    @Override
    public void updateIntegral(User user, int integral) {
        userDao.updateIntegral( user,integral );
    }

    @Override
    public void delete(List<Integer> ids) {
        userDao.delete( ids );
    }

    @Override
    public void edit(User user) {
        userDao.edit( user );
    }
}
