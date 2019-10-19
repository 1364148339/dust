package com.nsu.service;

import com.nsu.domain.bean.Welfare;
import org.springframework.stereotype.Service;

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
    void authentication(Welfare welfare);
}
