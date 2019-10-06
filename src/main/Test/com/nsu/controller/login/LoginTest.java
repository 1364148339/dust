package com.nsu.controller.login;

import com.nsu.domain.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/2
 */
public class LoginTest {

    /**
     * 注册
     */
    @Test
    public void registerTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        LoginController login = (LoginController) a.getBean( "loginController" );

        User user = new User();
        user.setN_name( "放生" );
        user.setP_number( "17716474476" );
        user.setEmail( "1364148339@qq.com" );
        user.setPwd( "123456" );

        String res =  login.register( user );
        System.out.println( res );
    }

    /**
     * 手机号登陆
     */
    @Test
    public void phoneLoginTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        LoginController login = (LoginController) a.getBean( "loginController" );

        User user = new User();
        user.setP_number( "17716474476" );
        user.setPwd( "123456" );

        String res =  login.phoneLogin( user );
        System.out.println( res );

    }

    /**
     * 手机号修改密码
     */
    @Test
    public void phoneUpdatePasswordTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        LoginController login = (LoginController) a.getBean( "loginController" );

        User user = new User();
        user.setP_number( "17716474476" );
        user.setPwd( "8888" );

        String res =  login.phoneUpdatePassword( user );
        System.out.println( res );
    }
}
