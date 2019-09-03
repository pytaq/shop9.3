package com.hxzy.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class Goods  implements Serializable {

    private Integer id;

    /**
     * 商品货号
     */
    private String goodssn;  

   /**
     * 一级分类
     */
    private Integer pcate;

    private String firstCateName;
    /**
     * 请选择二级分类
     */
    private Integer ccate;
    private String secondCateName;

    /**
     * 三级分类
     */
    private Integer tcate;
    private String thirdCateName;

    /**
     * 0为实体，1为虚拟
     */
    private Integer type;

    /**
     * 是否上架销售 1上架  2下架
     */
    private Integer status;

    /**
     * 显示上架顺序
     */
    private Integer displayorder;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面图片
     */
    private String thumb;

    /**
     * 商品简单描述
     */
    private String description;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 商品条码
     */
    private String productsn;

    /**
     * 本店售价
     */
    private BigDecimal marketprice;

    /**
     * 市场售价
     */
    private BigDecimal productprice;

    /**
     * 库存
     */
    private Integer total;

    /**
     * 0 拍下减库存 1 付款减库存 2 永久不减
     */
    private Integer totalcnf;

    /**
     * 创建时间
     */
    private Integer createtime;

    /**
     * 新品
     */
    private Integer isnew;

    /**
     * 免运费商品,打勾表示此商品不会产生运费花销，否则按照正常运费计算。
     */
    private Integer issendfree;

    /**
     * 热卖
     */
    private Integer ishot;

    /**
     * 打折
     */
    private Integer isdiscount;

    /**
     * 首页推荐
     */
    private Integer isrecommand;

    /**
     * 限时促销,1开启限时促销
     */
    private Integer istime;

    /**
     * 开启限时促销
     */
    private Integer timestart;

    /**
     * 关闭限时促销
     */
    private Integer timeend;

    /**
     * 已删除
     */
    private Integer deleted;

    /**
     * 商品详细描述
     */
    private String content;



    private static final long serialVersionUID = 1L;


 public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodssn() {
        return goodssn;
    }

    public void setGoodssn(String goodssn) {
        this.goodssn = goodssn;
    }

    public Integer getPcate() {
        return pcate;
    }

    public void setPcate(Integer pcate) {
        this.pcate = pcate;
    }

    public Integer getCcate() {
        return ccate;
    }

    public void setCcate(Integer ccate) {
        this.ccate = ccate;
    }

    public Integer getTcate() {
        return tcate;
    }

    public void setTcate(Integer tcate) {
        this.tcate = tcate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getProductsn() {
        return productsn;
    }

    public void setProductsn(String productsn) {
        this.productsn = productsn;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalcnf() {
        return totalcnf;
    }

    public void setTotalcnf(Integer totalcnf) {
        this.totalcnf = totalcnf;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getIsnew() {
        return isnew;
    }

    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    public Integer getIssendfree() {
        return issendfree;
    }

    public void setIssendfree(Integer issendfree) {
        this.issendfree = issendfree;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public Integer getIsdiscount() {
        return isdiscount;
    }

    public void setIsdiscount(Integer isdiscount) {
        this.isdiscount = isdiscount;
    }

    public Integer getIsrecommand() {
        return isrecommand;
    }

    public void setIsrecommand(Integer isrecommand) {
        this.isrecommand = isrecommand;
    }

    public Integer getIstime() {
        return istime;
    }

    public void setIstime(Integer istime) {
        this.istime = istime;
    }

    public Integer getTimestart() {
        return timestart;
    }

    public void setTimestart(Integer timestart) {
        this.timestart = timestart;
    }

    public Integer getTimeend() {
        return timeend;
    }

    public void setTimeend(Integer timeend) {
        this.timeend = timeend;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstCateName() {
        return firstCateName;
    }

    public void setFirstCateName(String firstCateName) {
        this.firstCateName = firstCateName;
    }

    public String getSecondCateName() {
        return secondCateName;
    }

    public void setSecondCateName(String secondCateName) {
        this.secondCateName = secondCateName;
    }

    public String getThirdCateName() {
        return thirdCateName;
    }

    public void setThirdCateName(String thirdCateName) {
        this.thirdCateName = thirdCateName;
    }
}