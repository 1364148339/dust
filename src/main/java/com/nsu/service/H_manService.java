package com.nsu.service;

import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/15
 */
@Service("h_manService")
public interface H_manService {
    /**
     * 通过用户id--查询志愿者id-->他的结对的受助者信息
     * @return List<H_man> 受助者列表
     */
    List<H_man> findById(User user);


    /**
     * 添加受助者
     * @param h_man
     */
    void addH_man(H_man h_man);

    /**
     * 每次拿15条数据出来
     * @return
     */
    List<H_man> findBySection( Long x, Long y);

    /**
     * 获取位置 省+市+区
     * @return
     */
    List<String> findByAllPosition();
}
