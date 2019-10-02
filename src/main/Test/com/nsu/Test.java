//package com.nsu;
//
//import com.nsu.dao.UserDao;
//import com.nsu.domain.User;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//
///**
// * 内容：
// *
// * @author: wangqiao
// * @time: 2019/9/19
// */
//public class Test {
//
//    //测试注册用户
//    @org.junit.Test
//    public void addTest()
//    {
//        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) a.getBean( "userDao" );
//
//        User user = new User();
//        user.setMailbox( "242853208@qq.com" );
//        user.setName( "小拓" );
//        user.setPhone_number( "18870428395" );
//        user.setPassword( "147258" );
//
//        userDao.addUser( user );
//
//    }
//
//    //测试通过手机号 查找密码
//    @org.junit.Test
//    public void phoneTest()
//    {
//        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) a.getBean( "userDao" );
//        User user = new User();
//        user.setPhone_number( "17716474476" );
//        String password = userDao.findPhonePassword( user );
//        System.out.println( password );
//    }
//
//    //测试通过邮箱 查找密码
//    @org.junit.Test
//    public void mailboxTest()
//    {
//        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) a.getBean( "userDao" );
//        User user = new User();
//        user.setMailbox( "242853208@qq.com" );
//        String password = userDao.findMailboxPassword( user );
//        System.out.println( password );
//    }
//}
