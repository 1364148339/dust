package com.nsu.dao.bean;

import com.nsu.domain.bean.User;
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
    @Insert( "INSERT INTO User (n_name,p_number,email,pwd) VALUES (#{n_name},#{p_number},#{email},#{pwd})" )
    void addUser(User user);

    /**
     * 根据手机号 查找密码
     * @param user
     * @return
     */
    @Select( "select pwd from User where p_number = #{p_number}" )
    String findPhonePassword(User user);

    /**
     * 根据邮箱 查找密码
     * @param user
     * @return
     */
    @Select( "select pwd from User where email = #{email}" )
    String findEmailPassword(User user);

    /**
     * 查找这个手机号
     * @param user
     * @return
     */
    @Select( "select p_number from User where p_number = #{p_number}" )
    Object findPhoneNumber(User user);

    /**
     * 查找邮箱
     * @param user
     * @return
     */
    @Select( "select email from User where email = #{email}" )
    Object findEmail(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Update( "update User set pwd = #{pwd} where p_number = #{p_number}" )
    void updatePassword(User user);
}
