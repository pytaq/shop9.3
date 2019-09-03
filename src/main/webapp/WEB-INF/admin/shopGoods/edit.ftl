<#assign ctx="${request.contextPath}">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品信息编辑</title>


    <link href="${ctx }/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx }/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx }/static/css/animate.css" rel="stylesheet">

    <!-- kineditor样式-->
    <link href="${ctx }/static/js/plugins/kindeditor/themes/default/default.css" rel="stylesheet">

    <!-- bootstrap-validator验证 -->
    <link href="${ctx }/static/js/plugins/validator/css/bootstrapValidator.css" rel="stylesheet">

    <!-- bootstrap-dialog -->
    <link href="${ctx }/static/js/plugins/dialog/css/bootstrap-dialog.css" rel="stylesheet">

    <link href="${ctx }/static/css/style.css?v=4.1.0" rel="stylesheet">


</head>
<body    data-project="${ctx }"  >

<div class="form1">
    <form class="form-horizontal"  id="addform" method="post"  action="">
        <div  data-example-id="togglable-tabs" style="min-height: 600px;">

            <ul id="myTabs" class="nav nav-tabs" role="tablist"   >
                <li role="presentation" class="active">
                    <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">基本信息</a>
                </li>
                <li role="presentation" class="">
                    <a href="#imgs" role="tab" id="imgs-tab" data-toggle="tab" aria-controls="imgs" aria-expanded="false">图片库</a>
                </li>
                <li role="presentation" class="">
                    <a href="#details" role="tab" id="details-tab" data-toggle="tab" aria-controls="details" aria-expanded="false">商品详情信息</a>
                </li>

            </ul>
            <div id="myTabContent" class="tab-content" style="padding-top:20px;">
                <!--商品基本信息-->
                <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="col-sm-2 control-label">一级分类</label>
                            <div class="col-sm-10">
                                <select  id="firstCate" name="pcate" class="form-control">
                                    <#list   first as f>
                                        <#if f.id==goods.pcate >
                                            <option value="${f.id}" selected>${f.name}</option>
                                        <#else >
                                            <option value="${f.id}" >${f.name}</option>
                                        </#if>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label class="col-sm-2 control-label">二级分类</label>
                            <div class="col-sm-10">
                                <select  id="secondCate" name="ccate" class="form-control">
                                    <#list   second as f>
                                         <#if f.id==goods.ccate >
                                             <option value="${f.id}" selected>${f.name}</option>
                                         <#else >
                                             <option value="${f.id}" >${f.name}</option>
                                         </#if>

                                    </#list>
                                </select>
                            </div>

                        </div>

                        <div class="col-md-4">
                            <label class="col-sm-2 control-label">三级分类</label>
                            <div class="col-sm-10">
                                <select  id="thirdCate" name="tcate" class="form-control">
                                    <#list   third as f>
                                        <#if f.id==goods.tcate >
                                           <option value="${f.id}" selected>${f.name}</option>
                                        <#else >
                                            <option value="${f.id}">${f.name}</option>
                                        </#if>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-4">
                            <label  class="col-sm-2 control-label">商品名称</label>
                            <div class="col-sm-10">
                                <input type="hidden" id="id" name="id" value="${goods.id}" />
                                 <input type="text" class="form-control" name="title" id="title"  value="${goods.title}"   placeholder="商品名称">
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <label  class="col-sm-2 control-label">商品描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="description" name="description" value="${goods.description}" placeholder="简单描述">
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <label  class="col-sm-2 control-label">商品货号</label>
                            <div class="col-sm-10">
                            <input type="text" class="form-control" name="goodssn" id="goodssn" value="${goods.goodssn}"  placeholder="商品货号">
                                </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-4">
                            <label  class="col-sm-2 control-label">商品特性</label>
                            <div class="col-sm-10">

                                <input type="checkbox"   name="isnew" id="isnew" value="1"  <#if goods.isnew==1>checked</#if> >新品
                                <input type="checkbox"  name="ishot" id="ishot"  value="1" <#if goods.ishot==1>checked</#if> >热卖
                                <input type="checkbox"   name="isdiscount" id="isdiscount" value="1" <#if goods.isdiscount==1>checked</#if> >打折
                                <input type="checkbox"   name="isrecommand" id="isrecommand" value="1" <#if goods.isrecommand==1>checked</#if> >首页推荐
                                <input type="checkbox"   name="issendfree" id="issendfree" value="1"  <#if goods.issendfree==1>checked</#if>  >免邮费
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4">
                            <label   class="col-sm-2 control-label">商品重量</label>
                            <div class="col-sm-10">
                            <input type="number" class="form-control"  min="0" step="0.01" value="${goods.weight?string("0.00")}"   name="weight" id="weight" placeholder="商品重量">
                                </div>
                        </div>

                        <div class="col-sm-4">
                            <label   class="col-sm-2 control-label">商品条码</label>
                            <div class="col-sm-10">
                            <input type="text" name="productsn" class="form-control" id="productsn" value="${goods.productsn}"   placeholder="商品条码">
                                </div>
                        </div>


                        <div class="col-sm-4">
                            <label  class="col-sm-2 control-label">商品库存</label>
                            <div class="col-sm-10">
                            <input type="number" class="form-control"  name="total" min="0" id="total"  value="${goods.total}"  placeholder="库存">
                                </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4">
                            <label class="col-sm-2 control-label">本店售价</label>
                            <div class="col-sm-10">
                            <input type="number" min="0" step="0.01" name="marketprice" class="form-control" value="${goods.marketprice?string("0.00")}" id="marketprice"  placeholder="售价">
                                </div>
                        </div>

                        <div class="col-sm-4">
                            <label   class="col-sm-2 control-label">市场售价</label>
                            <div class="col-sm-10">
                            <input type="number" min="0"  step="0.01"  class="form-control" name="productprice"  value="${goods.productprice?string("0.00")}"  id="productprice" placeholder="市场售价">
                                </div>
                        </div>


                        <div class="col-sm-4">

                            <label   class="col-sm-2 control-label">排序</label>
                            <div class="col-sm-10">
                                <input type="number" min="0"   class="form-control" name="displayorder" value="${goods.displayorder}"   id="displayorder"   placeholder="越大的排在越前面">
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-4">
                            <label class="col-sm-2 control-label">限时促销</label>
                            <div class="col-sm-10">
                                <input type="checkbox" id="istime" name="istime"   value="1" <#if goods.istime==1>checked</#if>  >
                            </div>
                        </div>

                        <div class="col-sm-6" id="time"  <#if goods.istime==0> style="display: none;" </#if> >

                                <label   class=" control-label">开始时间</label>
                                <input type="text"    name="timestart"  id="timestart" placeholder="促销开始时间" value="${goods.timestart!}">
                                <label   class=" control-label">结束时间</label>
                                <input type="text"     name="timeend"  id="timeend" placeholder="促销结束售价" value="${goods.timeend!}">

                        </div>

                    </div>


                </div>


                <!--商品图片库-->
                <div role="tabpanel" class="tab-pane fade" id="imgs" aria-labelledby="imgs-tab">
                    <div class="form-group">
                        <button  class="btn btn-primary"  type="button" id="btnUploads">批量上传图片</button>
                    </div>

                    <div class="form-group" id="prevImage">

                        <#list picList as pic>
                            <div class="col-md-3 itemImage">
                                <div class="thumbnail">
                                    <img data-src="${pic.picurl}" src="${pic.picurl}" style="width:250px;height:250px;" data-holder-rendered="true"  >
                                    <div class="caption">
                                        <p>
                                            <#if  goods.thumb!=pic.picurl >
                                                  <a  class="btn btn-success converSet"   >设为封面</a>
                                                  <a  class="btn btn-danger deleteImg"  data-id="${pic.id}"  >删除</a>
                                             <#else>
                                                 <a  class="btn btn-default converSet"  style="visibility: hidden;" >设为封面</a>
                                                 <a  class="btn btn-danger deleteImg"  style="visibility: hidden;"  data-id="${pic.id}"  >删除</a>
                                            </#if>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>

                <!-- 商品详情-->
                <div role="tabpanel" class="tab-pane fade" id="details" aria-labelledby="details-tab">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <textarea id="content" name="content" class="form-control" style="width:100%;height:500px;visibility:hidden;">${goods.content}</textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>

         <div class="row">
             <button type="button" class="btn btn-success" id="btnSave">保存产品</button>
         </div>
    </form>

</div>


<!-- 全局js -->
<script src="${ctx }/static/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx }/static/js/bootstrap.min.js?v=3.3.6"></script>

<!-- Peity -->
<script src="${ctx }/static/js/plugins/peity/jquery.peity.min.js"></script>

<!-- bootstrap-validator验证 -->
<script src="${ctx }/static/js/plugins/validator/js/bootstrapValidator.js"></script>
<script src="${ctx }/static/js/plugins/validator/js/language/zh_CN.js"></script>

<!-- kineditor-->
<script src="${ctx }/static/js/plugins/kindeditor/kindeditor-all.js"></script>
<script src="${ctx }/static/js/plugins/kindeditor/lang/zh-CN.js"></script>

<!-- bootstrap-dialog -->
<script src="${ctx }/static/js/plugins/dialog/js/bootstrap-dialog.js"></script>

<!-- 自定义js -->
<script src="${ctx }/static/js/content.js?v=1.0.0"></script>

<!-- 自定义 user.js -->
<script src="${ctx }/static/js/manage/addshopgoods.js?v=1.0.0"></script>

</body>
</html>