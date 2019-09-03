package com.hxzy.service;

import com.hxzy.common.service.BaseService;
import com.hxzy.entity.Goods;

public interface GoodsService extends BaseService<Goods> {

    /**
     * 新增产品
     * @param goods 产品
     * @param thumbArr 图片库
     * @return
     */
    boolean insert(Goods goods,String[] thumbArr);

}
