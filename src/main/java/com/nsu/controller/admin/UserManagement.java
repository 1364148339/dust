package com.nsu.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsu.domain.Results;
import com.nsu.domain.bean.User;
import com.nsu.service.UserService;
import com.nsu.until.ResultUtil;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 内容：
 * 用户管理
 * @author: wangqiao
 * @time: 2019/11/18
 */
@Controller
@RequestMapping("/userManagement")
@Api(tags="UserController",description="用户管理")
public class UserManagement {
    @Autowired
    private UserService userService;

    /**
     * 得到全部的user
     * @param page  页码
     * @param limit 行数
     * @return
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public @ResponseBody Results findAll(@RequestParam int page, @RequestParam int limit)
    {
        PageHelper.startPage( page,limit );
        List<User> list = userService.findAll();
        PageInfo<User> pi = new PageInfo<>(list);
        return ResultUtil.selects( pi.getTotal(),list );
    }

    /**
     * 全局模糊搜索
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public @ResponseBody Results searchAll(@RequestParam int page, @RequestParam int limit,@RequestParam String key)
    {
        PageHelper.startPage( page,limit );
        List<User> list = userService.searchAll( key );
        PageInfo<User> pi = new PageInfo<>(list);
        return ResultUtil.selects( pi.getTotal(),list );
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody Results deleteSection(@RequestBody String ids)
    {
        List<Integer> list =  (List<Integer>)JSONObject.parseObject( ids ).get( "ids" );
        if(list.size()<=0) return ResultUtil.failure( null,null );
        userService.delete( list );
        return ResultUtil.selects( null,null);
    }

    /**
     * 修改：
     * 昵称,手机号，密码，签名，邮箱
     * @param
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public @ResponseBody Results editInfo(@RequestBody User user)
    {
        userService.edit( user );
        return ResultUtil.selects( null,null);
    }
}
