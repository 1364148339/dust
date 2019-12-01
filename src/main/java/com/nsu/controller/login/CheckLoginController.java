package com.nsu.controller.login;

import com.nsu.domain.bean.User;
import com.nsu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容：
 * 用于检查手机号/邮箱
 * @author: wangqiao
 * @time: 2019/10/2
 */
@Controller
@RequestMapping("/check")
@Api(tags="CheckLoginController",description="用于检查手机号/邮箱 是否存在")
public class CheckLoginController {

    @Autowired
    private UserService userService;

    /**
     * 判断是否存在该手机号
     * @param user
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:判断是否存在该手机号",notes="接口说明：需要user的手机号码")
    @RequestMapping(value="/checkPhoneNumber",method= RequestMethod.POST)
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
    @ApiOperation(httpMethod="POST",value="接口标题:判断是否存在该邮箱",notes="接口说明：需要user的邮箱")
    @RequestMapping("/checkEmail")
    public @ResponseBody String checkEmail(@RequestBody User user)
    {
        if(userService.checkEmail( user )) return "1";
        else return "0";
    }

}
