package com.nsu.controller.homepage;

import com.nsu.domain.bean.Luser;
import com.nsu.domain.bean.Volunteer;
import com.nsu.domain.bean.Welfare;
import com.nsu.service.LuserService;
import com.nsu.service.VolunteerService;
import com.nsu.service.WelfareService;
import com.nsu.until.LuserUntil;
import com.nsu.until.VolunteerUntil;
import com.nsu.until.WelfareUnitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    @RequestMapping("/userToExamineLuser")
    public @ResponseBody String userToExamineLuser(HttpServletRequest request, @RequestParam MultipartFile[] uploads , @RequestParam Map<String,String> map) throws IOException {
        //解析map  封装数据
        Luser luser = LuserUntil.analysisMap( map );
        //解析图片
        // 上传的位置 Luser+用户id
        String path = request.getSession().getServletContext().getRealPath( "/upload/Luser/"+luser.getId().toString());
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        String str = "http://45.40.206.100:8080/test/upload/Luser/"+luser.getId().toString()+"/";


        String filename = null;

        //r   正面
        //获取到上传文件的名称
        filename = uploads[0].getOriginalFilename();
        //  上传文件
        uploads[0].transferTo(new File(file,filename));
        luser.setRid_photo( str+filename );

        //l   反面
        //获取到上传文件的名称
        filename = uploads[1].getOriginalFilename();
        //  上传文件
        uploads[1].transferTo(new File(file,filename));
        luser.setLid_photo( str+filename );


        //图片上传完成  属性封装完毕
        luserService.addAuthentication( luser );
        return "1";
    }

    /**
     * 志愿者认证
     * @param request
     * @param uploads 三张图片 正反照+正脸照
     * @param map 志愿者认证所需参数
     * @return
     */
    @RequestMapping("/userToExamineVolunteer")
    public @ResponseBody String userToExamineVolunteer(HttpServletRequest request, @RequestParam MultipartFile[] uploads , @RequestParam Map<String,String> map) throws IOException
    {
        Volunteer volunteer = VolunteerUntil.analysisMap( map );
        // 上传的位置 Volunteer+用户id
        String path = request.getSession().getServletContext().getRealPath( "/upload/Volunteer/"+volunteer.getId().toString());
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        String str = "http://45.40.206.100:8080/test/upload/Volunteer/"+volunteer.getId().toString()+"/";
        String filename = null;
        //r   正面
        //获取到上传文件的名称
        filename = uploads[0].getOriginalFilename();
        uploads[0].transferTo(new File(file,filename));
        volunteer.setRid_photo( str+filename );

        // ff 正脸照
        filename = uploads[2].getOriginalFilename();
        uploads[2].transferTo(new File(file,filename));
        volunteer.setFf_photo( str+filename );

        //l   反面
        filename = uploads[1].getOriginalFilename();
        uploads[1].transferTo(new File(file,filename));
        volunteer.setLid_photo( str+filename );

         volunteerService.addAuthentication( volunteer );
         return "1";
    }

    //公益组织认证
    @RequestMapping("/userToExamineWelfare")
    public @ResponseBody String userToExamineWelfare(HttpServletRequest request, @RequestParam MultipartFile upload , @RequestParam Map<String,String> map) throws IOException
    {
        Welfare welfare = WelfareUnitl.analysisMap( map );
        // 上传的位置 Welfare
        String path = request.getSession().getServletContext().getRealPath( "/upload/Welfare");
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        String str = "http://45.40.206.100:8080/test/upload/Welfare/";
        String filename = welfare.getId().toString()+".jpg";
        upload.transferTo( new File(file,filename));
        welfare.setBs_url( str+filename );
        welfareService.authentication( welfare );
        return "1";
    }

}
