package com.nsu.controller;


import com.nsu.until.TimeUntile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
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
    public String find()
    {
        return "success";
    }

    @RequestMapping("/fileUpLoad")//上传
    public @ResponseBody String fileUpLoad(HttpServletRequest request) throws Exception
    {
        // 上传的位置 + 年/月
        String path = request.getSession().getServletContext().getRealPath( "/uploads/" + TimeUntile.getTime() );
        // 判断，该路径是否存在
        File file = new File( path );
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }
        //创建磁盘工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload( factory );
        //判断是否为空
        if (fileUpload == null) return "0";
        List<FileItem> list = fileUpload.parseRequest( request );
        for (FileItem fileItem : list) {
            // 判断文件项是普通字段，还是上传的文件
            if (fileItem.isFormField()) {

            } else {
                // 上传文件项

                // 获取上传文件的名称
                String filename = fileItem.getName();
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace( "-", "" );
                filename = uuid + "_" + filename;
                // 上传文件
                fileItem.write( new File( file, filename ) );
                // 删除临时文件
                fileItem.delete();
            }
        }
        return "1";
    }

    @RequestMapping("/fileDownLoad")//下载
    public void fileDownLoad (HttpServletRequest request, HttpServletResponse response)
    {
        InputStream inputStream = null;
        //得到图片路径
        String path = request.getSession().getServletContext().getRealPath( "/uploads/" + TimeUntile.getTime() ) + "/1.jpg";
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
