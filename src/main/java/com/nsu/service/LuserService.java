package com.nsu.service;


import com.nsu.domain.bean.Luser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("luserService")
public interface LuserService {

    /**
     * 爱心人士认证
     * @param luser 爱人人士
     * @param uploads 图片组
     * @param path 上传路径
     * @throws IOException
     */
    Boolean addAuthentication(Luser luser, MultipartFile[] uploads,String path) throws IOException;
}
