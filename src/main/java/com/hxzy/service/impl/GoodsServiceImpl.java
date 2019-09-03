package com.hxzy.service.impl;

import com.hxzy.common.service.impl.BaseServiceImpl;
import com.hxzy.entity.Goods;
import com.hxzy.entity.GoodsPic;
import com.hxzy.entity.ShopCategory;
import com.hxzy.mapper.GoodsMapper;
import com.hxzy.mapper.GoodsPicMapper;
import com.hxzy.service.GoodsPicService;
import com.hxzy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    private GoodsMapper shopGoodsMapper;

    @Autowired
    private GoodsPicMapper  goodsPicMapper;


    @Autowired
    public void setShopGoodsMapper(GoodsMapper shopGoodsMapper) {
        this.shopGoodsMapper = shopGoodsMapper;
        super.setBaseMapper(shopGoodsMapper);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insert(Goods goods, String[] thumbArr) {

        boolean result= this.shopGoodsMapper.insert(goods)>0;

        if(result){
            //新增shop_goods_piclist
            //再插入相册，循环新增
            List<GoodsPic>  goodsPicArr=new ArrayList<>();
            for(String url  : thumbArr){
                GoodsPic  gp=new GoodsPic();
                gp.setGoodid(goods.getId());
                gp.setPicurl(url);
                goodsPicArr.add(gp);
            }

            //保存图片
            result=goodsPicMapper.insertBatch(goodsPicArr)>0;
        }else{
            throw new RuntimeException("新增产品失败");
        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean insert(Goods goods) {
        return this.shopGoodsMapper.insert(goods)>0;
    }
}


