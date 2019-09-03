package com.hxzy.entity;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 商品图片库
 */
@Data
public class GoodsPic implements Serializable {

    /**
     * '图片地址'
     */
    private String picurl;
    /**
     * 商品编号
     */
    private Integer goodid;
    private Integer id;


}
