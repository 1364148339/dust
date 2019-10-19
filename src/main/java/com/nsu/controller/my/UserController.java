package com.nsu.controller.my;

import com.nsu.domain.bean.User;
import com.nsu.service.UserService;
import com.nsu.until.TimeUntile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * 内容：
 * 个人信息
 * @author: wangqiao
 * @time: 2019/10/9
 */
@Controller
@RequestMapping("/my")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 通过id  获取个人信息
     * @param user
     * @return 1
     */
    @RequestMapping("/userInfo")
    public @ResponseBody User getUserById(@RequestBody User user)
    {
        return userService.findById( user );
    }

    /**
     * 修改头像
     * @param request
     * @param upload 上传的图片
     * @param id 用户id
     * @return 1 0
     */
    @RequestMapping("/updateHeadPortrait")
    public @ResponseBody User updateHeadPortrait(HttpServletRequest request, @RequestBody MultipartFile upload,String id)throws Exception
    {
        User user = new User();
        user.setId( new Long( id ) );
        //判断有没有该用户
        if(userService.findById( user )==null) return null;
        // 上传的位置 + 年/月
        String path = request.getSession().getServletContext().getRealPath( "/upload/HeadPortrait");
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        //获取文件名
        String str = upload.getOriginalFilename();
        //  以用户id为头像图片命名+后缀名
        String filename = user.getId().toString()+"."+str.substring( str.indexOf( "." )+1 );
        //  上传文件
        upload.transferTo(new File(file,filename));
        //把信息填充进去
        user.setH_photo( "http://45.40.206.100:8080/test/upload/HeadPortrait/"+filename );
        //调用修改的api
        userService.updatePhoto( user );
        return user;
    }
    /**
     * 修改昵称+签名
     * @Return 1
     */
    @RequestMapping("/updateInfo")
    public @ResponseBody User updateInfo(@RequestBody User user)
    {
        //判断有没有该用户
        if(userService.findById( user )==null) return null;
        //修改昵称
        if(user.getN_name()!=null) userService.updateName( user );
        //修改签名
        if(user.getAutograph()!=null) userService.updateAutograph( user );
        return user;
    }

}
