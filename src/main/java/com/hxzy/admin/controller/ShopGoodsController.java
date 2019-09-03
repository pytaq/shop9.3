package com.hxzy.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzy.common.util.DateUtil;
import com.hxzy.entity.Goods;
import com.hxzy.entity.GoodsPic;
import com.hxzy.entity.ShopCategory;
import com.hxzy.service.GoodsPicService;
import com.hxzy.service.ShopCategoryService;
import com.hxzy.service.GoodsService;
import com.hxzy.vo.PageData;
import com.hxzy.vo.GoodsSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class ShopGoodsController {


   @Autowired
   private GoodsService service;

   @Autowired
   private ShopCategoryService categoryService;

   @Autowired
   private GoodsPicService  goodsPicService;


   @GetMapping(value = "/index")
   public String showgoods() {
      return "shopGoods/shopgoods";
   }


   //显示新增商品品页面
   @GetMapping(value = "/add")
   public  String showadd(Model model){
       //加载一级、二级、三级分类，并且 有联动效果
       List<ShopCategory>  firstCategory=this.categoryService.searchByParentId(0);
       model.addAttribute("first",firstCategory);

       int firstParentId = firstCategory.get(0).getId();
       List<ShopCategory> secondCategory = this.categoryService.searchByParentId(firstParentId);
       model.addAttribute("second",secondCategory);

       int secndParentId=secondCategory.get(0).getId();
       List<ShopCategory> thirdCategory=this.categoryService.searchByParentId(secndParentId);
       model.addAttribute("third",thirdCategory);

      return "shopGoods/addshopgoods";
   }

    //显示新增商品品页面
    @GetMapping(value = "/edit/{id}")
    public  String showedit(@PathVariable("id") int id, Model model){
        //查询产品
        Goods  goods=this.service.findOne(id);
        System.out.println(goods.getWeight().doubleValue());
        model.addAttribute("goods",goods);
        //查询产品图片
        List<GoodsPic>  picList=this.goodsPicService.serach(id);
        model.addAttribute("picList",picList);

        //加载一级、二级、三级分类，并且 有联动效果
        List<ShopCategory>  firstCategory=this.categoryService.searchByParentId(0);
        model.addAttribute("first",firstCategory);

        //二级
        int firstParentId =goods.getPcate();
        List<ShopCategory> secondCategory = this.categoryService.searchByParentId(firstParentId);
        model.addAttribute("second",secondCategory);

        //三级分类
        int secndParentId=goods.getCcate();
        List<ShopCategory> thirdCategory=this.categoryService.searchByParentId(secndParentId);
        model.addAttribute("third",thirdCategory);

        return "shopGoods/edit";
    }

   //产品查询ajax
   @ResponseBody
   @PostMapping(value = "/search")
   public PageData<Goods> searchAll(GoodsSearch shopGoodsSearch) {
      PageData<Goods> pageData = this.service.searchPaging(shopGoodsSearch);
      return pageData;

   }


   @ResponseBody
   @PostMapping(value = "/findone")
   public  Goods finone(int  id){
      Goods one = this.service.findOne(id);
      return one;
   }


   //新增保存
   @ResponseBody
   @PostMapping(value = "/addsave")
   public JSONObject save(Goods shopGoods,@PathVariable(required = false) String[] thumbArr) {
        JSONObject json = new JSONObject();
         shopGoods.setCreatetime(DateUtil.dateToInt(new Date()));
         shopGoods.setStatus(2);
         shopGoods.setType(0);
         shopGoods.setTotalcnf(1);  //付款才减库存
         shopGoods.setDeleted(0);
         //手动处理
         shopGoods.setIsdiscount( shopGoods.getIsdiscount()==null?0:  shopGoods.getIsdiscount());
         shopGoods.setIshot(shopGoods.getIshot()==null?0:shopGoods.getIshot());
         shopGoods.setIsnew(shopGoods.getIsnew()==null?0:shopGoods.getIsnew());
         shopGoods.setIssendfree(shopGoods.getIssendfree()==null?0:shopGoods.getIssendfree());
         shopGoods.setIsrecommand(shopGoods.getIsrecommand()==null?0:shopGoods.getIsrecommand());


         shopGoods.setThumb(thumbArr[0]);  //默认第一张为封面页

         boolean insert = this.service.insert(shopGoods,thumbArr);
         if (insert) {
            json.put("code", 0);
            json.put("message", "添加数据成功");
         } else {
            json.put("code", 500);
            json.put("message", "添加失败");
         }

      return  json;
   }

}
