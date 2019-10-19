package com.nsu.controller.login;

import com.nsu.controller.homepage.RotationController;
import com.nsu.domain.bean.Rotation;
import com.nsu.domain.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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


    }

    /**
     * 手机号修改密码
     */
    @Test
    public void phoneUpdatePasswordTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        RotationController rotationController = (RotationController) a.getBean( "rotationController" );


        Rotation rotation = new Rotation();
        rotation.setCity( "成都" );
        List<Rotation> rotations=  rotationController.getRotation( rotation );
        for(Rotation rotation1:rotations)
        {
            System.out.println( rotation1 );
        }
    }
}
