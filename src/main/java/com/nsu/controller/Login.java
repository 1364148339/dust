package com.nsu.controller;

import com.nsu.domain.User;
import com.nsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容：
 * 用于登陆注册
 * @author: wangqiao
 * @time: 2019/9/27
 */
@Controller
@RequestMapping("/login")
public class Login {

    @Autowired
    private UserService userService;


    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public @ResponseBody String register(@RequestBody User user)
    {
        userService.register( user );
        return "1";
    }

    /**
     * 通过手机号登陆
     *
     */
    @RequestMapping("/phoneLogin")
    public @ResponseBody String phoneLogin(@RequestBody User user)
    {
        if(userService.phoneLogin( user )) return "1";
        else return "0";
    }

    /**
     * 手机号重置密码
     *
     */
    @RequestMapping("/phoneFindPassword")
    public @ResponseBody String phoneFindPassword(@RequestBody User user)
    {
        userService.phoneFindPassword( user );
        return "1";
    }

    /**
     * 判断是否存在该手机号
     * @param user
     * @return
     */
    @RequestMapping("/findPhoneNumber")
    public @ResponseBody String findPhoneNumber(@RequestBody User user)
    {
        if(userService.findPhoneNumber( user )) return "1";
        else return "0";
    }

    /**
     * 判断是否存在该邮箱
     * @param user
     * @return
     */
    @RequestMapping("/findMailbox")
    public @ResponseBody String findMailbox(@RequestBody User user)
    {
        if(userService.phoneLogin( user )) return "1";
        else return "0";
    }
}
