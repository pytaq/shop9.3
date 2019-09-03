package com.hxzy.mapper;

import com.hxzy.entity.GoodsPic;

import java.util.List;

/**
 * 产品图
 */
public interface GoodsPicMapper {
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
    int delete(int id);

    /**
     * 批量新增图片
     * @param arr
     * @return
     */
    int insertBatch(List<GoodsPic> arr);
}
