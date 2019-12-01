package com.nsu.controller.homepage;

import com.nsu.domain.bean.Luser;
import com.nsu.domain.bean.Volunteer;
import com.nsu.domain.bean.Welfare;
import com.nsu.service.LuserService;
import com.nsu.service.VolunteerService;
import com.nsu.service.WelfareService;
import com.nsu.until.LuserUtil;
import com.nsu.until.VolunteerUtil;
import com.nsu.until.WelfareUitl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 内容：
 * 爱心人士认证
 * 志愿者认证
 * 公益组织认证
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Controller
@RequestMapping("/home")
@Api(tags="AuthenticationController",description="首页认证")
public class AuthenticationController {

    @Autowired
    private LuserService luserService;//爱心人士
    @Autowired
    private VolunteerService volunteerService;//志愿者
    @Autowired
    private WelfareService welfareService;//公益组织

    /**
     * 爱心人士认证
     * @param request
     * @param uploads 两张图片 正反照
     * @param map 爱心人士认证所需参数
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:爱心人士认证",notes="接口说明：需要两张图片 正反照，爱心人士认证所需参数")
    @RequestMapping("/userToExamineLuser")
    public @ResponseBody String userToExamineLuser(HttpServletRequest request, @RequestParam MultipartFile[] uploads , @RequestParam Map<String,String> map){
        if(map==null || map.size()<1) return "0";
        if(uploads==null || uploads.length<1) return "0";
        //解析map  封装数据
        Luser luser = LuserUtil.analysisMap( map );
        //解析图片
        // 上传的位置 Luser+用户id
        if(luser.getId()==null) return "0";
        String path = request.getSession().getServletContext().getRealPath( "/upload/Luser/"+luser.getId().toString());
        //图片上传完成  属性封装完毕
        try {
            if(luserService.addAuthentication( luser,uploads,path )==false) return "0";
        }catch (IOException e)
        {
            return "0";
        }
        return "1";
    }

    /**
     * 志愿者认证
     * @param request
     * @param uploads 三张图片 正反照+正脸照
     * @param map 志愿者认证所需参数
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:志愿者认证",notes="接口说明：需要三张图片 正反照+正脸照，志愿者认证所需参数")
    @RequestMapping("/userToExamineVolunteer")
    public @ResponseBody String userToExamineVolunteer(HttpServletRequest request, @RequestParam MultipartFile[] uploads , @RequestParam Map<String,String> map)
    {
        if(map==null || map.size()<1) return "0";
        if(uploads==null || uploads.length<3) return "0";
        Volunteer volunteer = VolunteerUtil.analysisMap( map );
        // 上传的位置 Volunteer+用户id
        String path = request.getSession().getServletContext().getRealPath( "/upload/Volunteer/"+volunteer.getId().toString());
        try {

            if(volunteerService.addAuthentication( volunteer,uploads,path )==false) return "0";

        }catch (IOException e)
        {
            return "0";
        }
        return "1";
    }


    /**
     * 公益组织认证
     * @param request
     * @param upload 营业执照
     * @param map 公益组织认证需要的参数
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:公益组织认证",notes="接口说明：营业执照，公益组织认证需要的参数")
    @RequestMapping("/userToExamineWelfare")
    public @ResponseBody String userToExamineWelfare(HttpServletRequest request, @RequestParam MultipartFile upload , @RequestParam Map<String,String> map)
    {
        if(map==null || map.size()<1) return "0";
        if(upload==null) return "0";
        Welfare welfare = WelfareUitl.analysisMap( map );
        // 上传的位置 Welfare
        String path = request.getSession().getServletContext().getRealPath( "/upload/Welfare");

        try {
            if(welfareService.authentication( welfare,upload,path )==false) return "0";
        }catch (IOException e)
        {
            return "0";
        }

        return "1";
    }

}
