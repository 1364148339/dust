package com.nsu.controller.login;

import com.nsu.domain.bean.User;
import com.nsu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags="CheckLoginController",description="用于登陆，注册，手机号找回密码")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:注册",notes="接口说明：需要user的注册参数")
    @RequestMapping("/register")
    public  @ResponseBody String register(@RequestBody User user)
    {
        return userService.register( user );
    }

    /**
     * 通过手机号登陆
     *
     */
    @ApiOperation(httpMethod="POST",value="接口标题:手机号登陆",notes="接口说明：需要user的账号密码")
    @RequestMapping("/phoneLogin")
    public  @ResponseBody User phoneLogin(@RequestBody User user)
    {

        return userService.phoneLogin( user );
    }

    /**
     * 手机号重置密码
     *
     */
    @ApiOperation(httpMethod="POST",value="接口标题:手机号重置密码",notes="接口说明：需要user的手机号和密码")
    @RequestMapping("/phoneFindPassword")
    public @ResponseBody String phoneUpdatePassword(@RequestBody User user)
    {
        return userService.phoneUpdatePassword( user );
    }


}
