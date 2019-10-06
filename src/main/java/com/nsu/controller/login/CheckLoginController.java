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
 * 用于检查手机号/邮箱 是否存在
 * @author: wangqiao
 * @time: 2019/10/2
 */

@Controller
@RequestMapping("/check")
public class CheckLoginController {

    @Autowired
    private UserService userService;

    /**
     * 判断是否存在该手机号
     * @param user
     * @return
     */
    @RequestMapping("/checkPhoneNumber")
    public @ResponseBody String checkPhoneNumber(@RequestBody User user)
    {
        if(userService.checkPhoneNumber( user )) return "1";
        else return "0";
    }

    /**
     * 判断是否存在该邮箱
     * @param user
     * @return
     */
    @RequestMapping("/checkEmail")
    public @ResponseBody String checkEmail(@RequestBody User user)
    {
        if(userService.checkEmail( user )) return "1";
        else return "0";
    }
}
