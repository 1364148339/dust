package com.nsu.controller.my;

import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.H_manService;
import com.nsu.service.VolunteerService;
import com.nsu.until.H_manUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 内容：
 * 我的结对
 * @author: wangqiao
 * @time: 2019/10/15
 */
@Controller
@RequestMapping("/my")
@Api(tags="PairController",description="我的结对")
public class PairController {

    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private H_manService h_manService;
    /**
     * 通过用户id-->得到结对的所有受助者信息
     * @param user
     * @return
     */
    @ApiOperation(httpMethod="POST",value="接口标题:得到结对的所有受助者信息",notes="接口说明：需要User的id")
    @RequestMapping("/getPair")
    public @ResponseBody List<H_man> getPair(@RequestBody User user)
    {
        return h_manService.findById( user );
    }

    /**
     * 填加结对
     * @param request
     * @param uploads  受助者照片+文章照片
     * @return
     * @throws Exception
     */
    @ApiOperation(httpMethod="POST",value="接口标题:填加结对",notes="接口说明：受助者照片+文章照片")
    @RequestMapping("/addPair")
    public @ResponseBody String upload_Article(HttpServletRequest request, @RequestParam MultipartFile[] uploads ,@RequestParam Map<String,String> map)
    {
        if(uploads==null || uploads.length<1) return "0";
        if(map==null || map.size()<1) return "0";
        //解析map
        Object[] objects = H_manUtil.analysisMap( map );
        H_man h_man = (H_man) objects[0];
        //通过用户id 查找志愿者
        Volunteer volunteer = volunteerService.findByUserId( (User) objects[1] );
        if(volunteer==null || volunteer.getV_id()==null) return "0";
        // 上传的位置 受助对象+[0-9]+志愿者id
        //根据志愿者id  分出10个包来 分别对10取余
        Long l = volunteer.getV_id()%10;
        String path = request.getSession().getServletContext().getRealPath( "/upload/Helper/"+l.toString()+"/"+volunteer.getV_id().toString());

        try{
            //添加结对
            if(volunteerService.addPair( h_man,volunteer, uploads,path)==false) return "0";


        }catch (IOException e)
        {
            return "0";
        }
        return "1";
    }
}