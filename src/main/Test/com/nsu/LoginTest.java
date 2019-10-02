//package com.nsu;
//
//import com.nsu.controller.Login;
//import com.nsu.domain.User;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * 内容：
// *
// * @author: wangqiao
// * @time: 2019/9/28
// */
//public class LoginTest {
//
//    @Test
//    public void TestphoneLogin( )
//    {
//        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Login login = (Login) a.getBean( "login" );
//
//        User user = new User();
//        user.setPhone_number( "17716474476" );
//        user.setPassword( "123456" );
//        String res =  login.phoneLogin( user );
//        System.out.println( res );
//    }
//
//
//    @Test
//    public void Testregister()
//    {
//        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Login login = (Login) a.getBean( "login" );
//
//        User user = new User();
//        user.setPhone_number( "17716474476" );
//        user.setPassword( "123456" );
//        user.setMailbox( "1364148339@qq.com" );
//        user.setName( "方式" );
//
//        String res =  login.register( user );
//
//        System.out.println( res );
//    }
//
//    @Test
//    public void TestUpdatePassword()
//    {
//        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Login login = (Login) a.getBean( "login" );
//
//        User user = new User();
//        user.setPhone_number( "17716474476" );
//        user.setPassword( "888888" );
//
//        login.phoneFindPassword( user );
//
//    }
//}
