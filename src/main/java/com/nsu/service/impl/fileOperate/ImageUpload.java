package com.nsu.service.impl.fileOperate;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 内容：
 * 上传图片
 * @author: wangqiao
 * @time: 2019/10/25
 */
@Repository
public class ImageUpload {
    /**
     * 添加结对的上传图片
     */
    public void volunteerAddPair(MultipartFile[] uploads, File file) throws IOException {

           for(int i=0;i<uploads.length;i++)
           {
               String filename = String.valueOf(i)+".jpg";
               uploads[i].transferTo(new File(file,filename));
           }
    }

}
