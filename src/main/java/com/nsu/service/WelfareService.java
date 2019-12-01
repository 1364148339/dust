package com.nsu.service;

import com.nsu.domain.bean.Welfare;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("welfareService")
public interface WelfareService {
    /**
     * 公益组织认证
     *
     */
    Boolean authentication(Welfare welfare, MultipartFile upload,String path) throws IOException;

    /**
     * 通过组织id查询 组织信息
     * @param welfare
     * @return
     */
    Welfare findById(Welfare welfare);
}
