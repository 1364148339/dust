package com.nsu.service;


import org.springframework.stereotype.Service;

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
     * 向审核表里丢数据
     * @param luser
     */
    void addAuthentication(com.nsu.domain.bean.Luser luser);
}
