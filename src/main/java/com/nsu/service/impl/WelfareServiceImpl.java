package com.nsu.service.impl;

import com.nsu.dao.bean.WelfareDao;
import com.nsu.domain.bean.Welfare;
import com.nsu.service.WelfareService;
import com.nsu.until.TimeUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 内容：
 * 公益组织
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("welfareServiceImpl")
public class WelfareServiceImpl implements WelfareService {

    @Autowired@Qualifier("welfareDao")
    private WelfareDao welfareDao;

    /**
     * 认证
     * @param welfare
     */
    @Override
    public Boolean authentication(Welfare welfare, MultipartFile upload, String path) throws IOException {
        //  创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        String str = TimeUtile.host+"upload/Welfare/";
        if(welfare.getId()==null) return false;
        String filename = welfare.getId().toString()+".jpg";
        upload.transferTo( new File(file,filename));
        welfare.setBs_url( str+filename );
        welfareDao.authentication( welfare );
        return true;
    }

    @Override
    public Welfare findById(Welfare welfare) {
        return welfareDao.findById( welfare );
    }
}
