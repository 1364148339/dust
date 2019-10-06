package com.nsu.controller.login;

import com.nsu.domain.bean.User;
import com.nsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容：
 * 用于登陆，注册，手机号找回密码
 * @author: wangqiao
 * @time: 2019/9/27
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public  @ResponseBody String register(@RequestBody User user)
    {
        return userService.register( user );
    }

    /**
     * 通过手机号登陆
     *
     */
    @RequestMapping("/phoneLogin")
    public  @ResponseBody String phoneLogin(@RequestBody User user)
    {
        if(userService.phoneLogin( user )) return "1";
        else return "0";
    }

    /**
     * 手机号重置密码
     *
     */
    @RequestMapping("/phoneFindPassword")
    public @ResponseBody String phoneUpdatePassword(@RequestBody User user)
    {
        userService.phoneUpdatePassword( user );
        return "1";
    }


}
