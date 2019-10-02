package com.nsu.dao;

import com.nsu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/9/27
 */
@Repository("userDao")
public interface UserDao {

    /**
     * 注册账号
     * @param user
     */
    @Insert( "INSERT INTO user (name,mailbox,phone_number,password) VALUES (#{name},#{mailbox},#{phone_number},#{password})" )
    void addUser(User user);

    /**
     * 根据手机号 查找密码
     * @param user
     * @return
     */
    @Select( "select password from user where phone_number = #{phone_number}" )
    String findPhonePassword(User user);

    /**
     * 根据邮箱 查找密码
     * @param user
     * @return
     */
    @Select( "select password from user where mailbox = #{mailbox}" )
    String findMailboxPassword(User user);

    /**
     * 判断是否存在这个手机号
     * @param user
     * @return
     */
    @Select( "select phone_number from user where phone_number = #{phone_number}" )
    Object findPhoneNumber(User user);

    /**
     * 判断是否存在这个邮箱
     * @param user
     * @return
     */
    @Select( "select mailbox from user where mailbox = #{mailbox}" )
    Object findMailbox(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Update( "update user set password = #{password} where phone_number = #{phone_number}" )
    void updatePassword(User user);
}
