package com.nsu.service.impl;

import com.nsu.dao.bean.H_manDao;
import com.nsu.dao.bean.VolunteerDao;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.Relation;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import com.nsu.service.VolunteerService;
import com.nsu.service.impl.fileOperate.HtmlAnalysis;
import com.nsu.service.impl.fileOperate.ImageUpload;
import com.nsu.until.TimeUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("volunteerServiceImpl")
public class VolunteerServiceImpl implements VolunteerService {


    @Autowired
    private H_manDao h_manDao;
    @Autowired @Qualifier("volunteerDao")
    private VolunteerDao volunteerDao;
    @Autowired//图片上传
    private ImageUpload imageUpload;
    @Autowired//html文件解析
    private HtmlAnalysis htmlAnalysis;
    /**
     * 查询所有志愿者
     * @return
     */
    @Override
    public List<Volunteer> findAll() {
        return null;
    }

    /**
     * 通过编号查询志愿者
     * @param volunteer 志愿者编号
     * @return
     */
    @Override
    public Volunteer findById(Volunteer volunteer) {
        return null;
    }

    /**
     * 通过用户编号查询志愿者
     * @param user
     * @return Volunteer
     */
    @Override
    public Volunteer findByUserId(User user) {
        return volunteerDao.findByUserId( user );
    }


    /**
     * 志愿者认证
     * @param volunteer 志愿者全部信息
     */
    @Override
    public Boolean addAuthentication(Volunteer volunteer,MultipartFile[] uploads,String path) throws IOException {
        long s = System.currentTimeMillis();
        if(volunteer==null) return false;
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        if(volunteer.getId()==null) return false;
        String str = TimeUtile.host+"upload/Volunteer/"+volunteer.getId().toString()+"/";
        //r   正面
        uploads[0].transferTo(new File(file,"r.jpg"));
        // f 正脸照
        uploads[2].transferTo(new File(file,"f.jpg"));
       //l   反面
        uploads[1].transferTo(new File(file,"l.jpg"));
        volunteer.setRid_photo( str+"r.jpg" );
        volunteer.setFf_photo( str+"f.jpg" );
        volunteer.setLid_photo( str+"l.jpg" );
        volunteerDao.authentication( volunteer );
        System.out.println( System.currentTimeMillis()-s );
        return true;
    }

    /**
     * 添加结对
     * @param h_man 受助者
     * @param volunteer 志愿者
     * @param uploads  受助者照片
     * @param path   得到照片存储路径
     */
    @Override
    public Boolean addPair(H_man h_man, Volunteer volunteer, MultipartFile[] uploads,String path) throws IOException {

        if(h_man.getIntroduce()==null) return false;
        //唯一标识符
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        // 上传的位置 受助者id
        path =  path+"/"+uuid;
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        Long l = volunteer.getV_id()%10;
        String str = TimeUtile.host+"upload/Helper/"+l.toString()+"/"+volunteer.getV_id().toString()+"/"+uuid+"/";
        //设置参数
        //头像的命名0.jpg
        //文章的图片命名从1.jpg开始
        if(uploads.length>1)
            h_man.setPath( str+"1.jpg");
        else
            h_man.setPath( null );
        //解析html
        String html = h_man.getIntroduce();
        htmlAnalysis.volunteerAddPair( html,str,file );
        //上传图片
        imageUpload.volunteerAddPair( uploads,file );
        //路径+名称.jpg   受助人的照片都是0.jpg
        h_man.setPhoto( str+"0.jpg" );
        //设置简介的html路径 路径+H_man.html
        h_man.setIntroduce( str+"H_man.html" );
        //添加受助人--然后先返回编号到h_man
        h_manDao.addH_man( h_man );
        //添加结对
        Relation relation = new Relation();
        //志愿者编号
        relation.setV_id( volunteer.getV_id() );
        //组织id
        if(volunteer.getO_id()!=null)
        relation.setO_id(volunteer.getO_id());
        else
        relation.setO_id( null );
        // 受助者编号
        relation.setH_id( h_man.getH_id() );
        //上传时间
        relation.setUp_time( TimeUtile.getTime());
        //添加结对
        volunteerDao.addPair( relation );
        return true;
    }

    /**
     * 参加活动
     * @param activity_volunteer 活动id+志愿者id
     */
    @Override
    public void joinActivity(Activity_Volunteer activity_volunteer) {
        volunteerDao.joinActivity( activity_volunteer );
    }
}
