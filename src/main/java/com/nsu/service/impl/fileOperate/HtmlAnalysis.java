package com.nsu.service.impl.fileOperate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.*;

/**
 * 内容：
 * 解析html文档
 * @author: wangqiao
 * @time: 2019/10/25
 */
@Repository
public class HtmlAnalysis {

    public void volunteerAddPair(String html,String str,File file) throws IOException {
        Document doc = Jsoup.parse(html);
        Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        //修改图片的地址
        for(int i=0;i<images.size();i++)
        {
            String filename = String.valueOf(i)+".jpg";
            images.get( i ).attr( "src",str+filename);
        }
        //拿到修改后的html  String
        html = doc.html();

        FileOutputStream fileOutputStream = new FileOutputStream( new File(file,"H_man.html"));
        OutputStreamWriter osw = new OutputStreamWriter( fileOutputStream,"UTF-8" );
        osw.write( html );
        osw.flush();
        osw.close();
    }
}
