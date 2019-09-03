package com.hxzy.service;

import com.hxzy.entity.GoodsPic;

import java.util.List;

public interface GoodsPicService {
    /**
     * 根据产品编号 查询它图片
     * @param goodsId
     * @return
     */
    List<GoodsPic> serach(int goodsId);

    /**
     * 根据id删除图片
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 批量新增图片
     * @param arr
     * @return
     */
    boolean insertBatch(List<GoodsPic> arr);
}
