
var projectName = ''; // 得到项目名称
var primarykey =0; // 新增操作,如果>0必定修改
var imageCount=0;   //新增的几张图
var contentEditor;        //富文本框
//初始化
$(function () {
    projectName = $.trim($("body").attr("data-project"));

    initKindeditor();

    //批量上传图片
    uploadAllImages();

    //新增删除图片,移出那个div
    deleteFunction();

    //产品分类级联
    categoryCascade();

    //验证数据有效性
    validatorForm();

    //点击保存
    $("#btnSave").click(saveFormData);
});

//产品分类级联
function categoryCascade(){
    //一级 (动，二级变)
    $("#firstCate").change(function(){
        var pid=$(this).val();
        $("#thirdCate").empty();  //第三级肯定变
        categoryChange(pid,"#secondCate" );
    });

    //二级(动，三级变)
    $("#secondCate").change(function(){
        var pid=$(this).val();
        categoryChange(pid,"#thirdCate" );
    });

}

/**
 * 根据变化填充数据
 * @param pid
 * @param selector
 */
function categoryChange(pid,selector){
    $.ajax({
        type:"get",
        url:projectName+"/admin/manage/category/parentId/"+pid,
        dataType:"json",
        success:function(resp){
            if(resp.code===0){
                var cateSelect=$(selector);  //下拉列
                cateSelect.empty();           //清空节点
                //循环填充
                $.each(resp.data, function(index, obj){
                    var str=`<option value="${obj.id}">${obj.name}</option>`;
                    cateSelect.append($(str));

                    //下标为0，并且是第二级，加载第三数据
                    if(index==0 && selector=='#secondCate'){
                        categoryChange(obj.id,'#thirdCate');
                    }
                });
            }
        }
    });
}

function deleteFunction(){
    $(".deleteImg").off();  //移出所有事件

    $(".deleteImg").click(function(){
        //还要去判断它是否有 data-id的值，就要去删除数据库的值，删除之前它是否是封面
        $(this).parents("div.itemImage").remove();
        imageCount=imageCount-1; //图片长度-1
    });
}

//1、初始化富文本框
function initKindeditor(){
    KindEditor.ready(function(K) {
        contentEditor = K.create('textarea[name="content"]', {
            uploadJson : projectName+'/admin/image/upload',   //上传地址
            allowFileManager: false
        });
    });
}

//2、批量上传图片 http://kindeditor.net/ke4/examples/multi-image-dialog.html
function uploadAllImages(){

    KindEditor.ready(function(K) {
        var editor = K.editor({
            allowFileManager : false,
            uploadJson : projectName+'/admin/image/upload',   //上传地址
        });
        K('#btnUploads').click(function() {
            editor.loadPlugin('multiimage', function() {
                editor.plugin.multiImageDialog({
                    clickFn : function(urlList) {
                        console.log(urlList);
                        imageCount=imageCount+urlList.length; //记录图片长度
                        var prevDiv=K("#prevImage");
                        K.each(urlList, function(i, data) {
                            //es6语法
                            var str=`
                           <div class="col-md-3 itemImage">
                                <div class="thumbnail">
                                <img data-src="${data.url}" src="${data.url}" style="width:250px;height:250px;" data-holder-rendered="true"  >
                                <div class="caption">
                                <p> 
                                    <a  class="btn btn-default deleteImg"  >删除</a>
                                    <input type="hidden" name="thumbArr" value="${data.url}" >
                                </p>
                            </div>
                            </div>
                            </div>`;
                            //追加到页面
                            prevDiv.append( $(str));

                        });

                        //再重新注册事件
                        deleteFunction();

                        editor.hideDialog();
                    }
                });
            });
        });
    });
}



//表单验证
function validatorForm(){

    $('#addform').bootstrapValidator({
        excluded: [':disabled'],//排除其他样式
        message: '输入的值无效',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok', //验证通过的图标
            invalid: 'glyphicon glyphicon-remove',  //验证失败的图标
            validating: 'glyphicon glyphicon-refresh'  //正在验证中的图标
        },
        fields: {
            //添加验证的表单的name
            title:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '商品名称不能为空'
                    },
                } //validators验证结束

            }, //字段结束
            description:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '商品描述不能为空'
                    },
                } //validators验证结束
            },//字段结束
            goodssn:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '商品货号不能为空'
                    },
                    stringLength:{
                        min: 5,
                        max: 12,
                        message: '商品货号长度必须在5到12位之间'
                    }

                } //validators验证结束

            },//字段结束
            productsn:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '条形码不能为空'
                    },
                } //validators验证结束

            },//字段结束
            total:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '库存值不能为空'
                    },
                    integer: {
                        message: '库存值必须是整数',
                        // The default separators
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }

                } //validators验证结束

            },//password结束
            marketprice:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '售价不能为空'
                    },
                    numeric: {
                        message: '售价必须是数字',
                        // The default separators
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }

                } //validators验证结束

            }, //roleName结束
            productprice:{
                message: '输入的值无效',
                validators:{
                    notEmpty: {
                        message: '市场价不能为空'
                    },
                    numeric: {
                        message: '市场价必须是数字',
                        // The default separators
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }

                } //validators验证结束

            }//password结束

        }
    });
};


//保存操作
function saveFormData(){
    //首先 手动 触发验证框架
    var validator = $("#addform").data('bootstrapValidator');
    //手动触发验证
    validator.validate();
    //验证全部通过
    if(validator.isValid()){

        //手动触发kineditor同步
        contentEditor.sync();

       //收集参数，向后台提交数据
        var saveData=$("#addform").serialize();
        console.log(saveData);

        $.ajax({
            type:"POST",
            url:projectName+"/admin/goods/addsave",
            data:saveData,
            dataType:"json",
            success:function(resp){

                if(resp.code===0){
                    //对放框
                    BootstrapDialog.alert({
                        title: '提示',
                        message: resp.message,
                        type: BootstrapDialog.TYPE_SUCCESS, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
                        closable: true, // <-- Default value is false
                        draggable: true, // <-- Default value is false
                        callback: function(result) {
                            //点了OK
                            window.location.href=projectName+"/admin/goods/index";
                        }
                    });
                }else{

                    BootstrapDialog.alert({
                        title: '错误',
                        message: resp.message,
                        type: BootstrapDialog.TYPE_DANGER, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
                        closable: true, // <-- Default value is false
                        draggable: true // <-- Default value is false
                    });


                }
            }
        });


    }
}