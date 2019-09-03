package com.hxzy.vo;

import lombok.Data;

/**
 * 商品查询
 */
@Data
public class GoodsSearch extends PageSearch {
    private String title;
    private  Integer status;
}
