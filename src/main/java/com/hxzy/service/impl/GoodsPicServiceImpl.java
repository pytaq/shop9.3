package com.hxzy.service.impl;

import com.hxzy.entity.GoodsPic;
import com.hxzy.mapper.GoodsPicMapper;
import com.hxzy.service.GoodsPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GoodsPicServiceImpl implements GoodsPicService {

    @Autowired
    private GoodsPicMapper  goodsPicMapper;

    @Override
    public List<GoodsPic> serach(int goodsId) {
        return goodsPicMapper.serach(goodsId);
    }

    @Override
    public boolean delete(int id) {
        return goodsPicMapper.delete(id)>0;
    }

    @Override
    public boolean insertBatch(List<GoodsPic> arr) {
        return goodsPicMapper.insertBatch(arr)>0;
    }
}
