package com.nsu.controller.my;

import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.Relation;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.H_manService;
import com.nsu.service.VolunteerService;
import com.nsu.until.H_manUntil;
import com.nsu.until.TimeUntile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
public class PairController {

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private H_manService h_manService;

    /**
     * 通过用户id-->得到结对的所有儿童信息
     * @param user
     * @return
     */
    @RequestMapping("/getPair")
    public @ResponseBody List<H_man> getPair(@RequestBody User user)
    {
       return h_manService.findById( user );
    }


    /**
     * 填加结对
     * @param request
     * @param upload  受助者照片
     * @return
     * @throws Exception
     */
    @RequestMapping("/addPair")
    public @ResponseBody String upload_Article(HttpServletRequest request, @RequestParam MultipartFile upload ,@RequestParam Map<String,String> map)throws Exception
    {
        //解析map
        Object[] objects = H_manUntil.analysisMap( map );
        H_man h_man = (H_man) objects[0];
        Volunteer volunteer = volunteerService.findByUserId( (User) objects[1] );
        //查询数据库 得到受助对象的数量
        h_man.setH_id( h_manService.findNum()+1 );

        // 上传的位置 受助对象
        String path = request.getSession().getServletContext().getRealPath( "/upload/Helper");
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        String str = "http://45.40.206.100:8080/test/upload/Helper/";
        String url = new String(  );
        //  上传文件的名称
        String filename = h_man.getH_id().toString()+".jpg";
        //  上传文件
        upload.transferTo(new File(file,filename));
        //加上str 以空格为分隔符
        filename = str+filename;
        //合并
        url=url+filename;
        h_man.setPhoto( url );

        //添加
        h_manService.addH_man( h_man );
        //添加结对
        Relation relation = new Relation();
        //志愿者编号
        relation.setV_id( volunteer.getV_id() );
        //受助者编号
        relation.setH_id( h_man.getH_id() );
        //上传时间
        relation.setUp_time( TimeUntile.getTime() );
        //添加结对
        volunteerService.addPair( relation );
        return "1";
    }
}
