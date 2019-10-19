package com.nsu.service;

import com.nsu.domain.bean.Rotation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/11
 */
@Service
public interface RotationService {

    /**
     * 获取所有轮播图
     * @return
     */
    List<Rotation> findAll(Rotation rotation);
}
