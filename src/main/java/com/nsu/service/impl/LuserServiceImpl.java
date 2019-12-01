package com.nsu.service.impl;

import com.nsu.dao.bean.LuserDao;
import com.nsu.domain.bean.Luser;
import com.nsu.service.LuserService;
import com.nsu.until.TimeUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 内容：
 * 爱心人士
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("luserServiceImpl")
public class LuserServiceImpl implements LuserService {


    @Autowired@Qualifier("luserDao")
    private LuserDao luserDao;


    /**
     * 爱心人士认证
     * @param luser 爱人人士
     * @param uploads 图片组
     * @param path 上传路径
     * @throws IOException
     */
    @Override
    public Boolean addAuthentication(Luser luser, MultipartFile[] uploads, String path) throws IOException {
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        if(luser.getId()==null) return false;
        String str = TimeUtile.host+"upload/Luser/"+luser.getId().toString()+"/";
        //r   正面
        //获取到上传文件的名称
        String filename = uploads[0].getOriginalFilename();
        //  上传文件
        uploads[0].transferTo(new File(file,filename));
        luser.setRid_photo( str+filename );

        //l   反面
        //获取到上传文件的名称
        filename = uploads[1].getOriginalFilename();
        //  上传文件
        uploads[1].transferTo(new File(file,filename));
        luser.setLid_photo( str+filename );

        luserDao.addAuthentication( luser );
        return true;
    }
}
