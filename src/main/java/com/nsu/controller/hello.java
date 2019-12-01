package com.nsu.controller;


import com.nsu.until.TimeUtile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/9/18
 */
@Controller
public class hello {

    @RequestMapping("/find")
    public String admin()
    {
        return "admin/home";
    }

    @RequestMapping("/fileUpLoad")//上传
    public @ResponseBody String fileUpLoad(HttpServletRequest request, @RequestParam("upload") MultipartFile[] upload) throws Exception
    {
        // 上传的位置 + 年/月
        String path = request.getSession().getServletContext().getRealPath( "/uploads/" + TimeUtile.getTime() );
       //  创建File对象，一会向该路径下上传文件
         File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
         if(!file.exists()) {
           file.mkdirs();
         }
        for(MultipartFile multipartFile:upload)
        {
            //  获取到上传文件的名称
            String filename = multipartFile.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
            //  把文件的名称唯一化
            filename = uuid+"_"+filename;
            //  上传文件
            multipartFile.transferTo(new File(file,filename));

        }
          return "1";
    }

    @RequestMapping("/fileDownLoad")//下载
    public void fileDownLoad (HttpServletRequest request, HttpServletResponse response)
    {
        InputStream inputStream = null;
        //得到图片路径
        String path = request.getSession().getServletContext().getRealPath( "/uploads/" + TimeUtile.getTime() ) + "/1.jpg";
        //得到文件对象
        File file = new File( path );
        try {
            //得到输入流
            inputStream = new FileInputStream( file );
            //定义一个字节数组
            byte[] data = null;
            //打开字节输出流
            ByteArrayOutputStream bout = new ByteArrayOutputStream( (int) file.length() );
            byte[] buffer = new byte[1024];
            int len = -1;
            //开始读取文件
            while ((len = inputStream.read( buffer )) != -1) {
                 bout.write( buffer, 0, len );
            }
             data = bout.toByteArray();
             inputStream.close();
             bout.close();
             response.getOutputStream().write( data );
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}
