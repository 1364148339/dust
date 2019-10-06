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
public class CheckTest {
    /**
     * 检查手机号是否存在
     */
    @Test
    public void checkPhoneNumberTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        CheckLoginController check = (CheckLoginController)a.getBean( "checkActivity" );

        User user = new User();
        user.setP_number( "17777777776" );

        String  res =check.checkPhoneNumber( user );
        System.out.println( res );
    }

    /**
     * 检查邮箱是否存在
     */
    @Test
    public void checkEmailTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        CheckLoginController check = (CheckLoginController)a.getBean( "checkActivity" );

        User user = new User();
        user.setEmail( "cuayfb@outlook.com" );

        String  res =check.checkEmail( user );
        System.out.println( res );
    }
}
