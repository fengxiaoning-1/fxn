<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="后台管理系统">
    <meta name="description" content="致力于提供通用版本后台管理解决方案">

    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
    <link rel="stylesheet" href="${ctx}/static/layui_v2/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/css/global.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/personal.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">
    <script src="${ctx}/static/layui_v2/layui.js"></script>
<body>
<div class="larry-grid layui-anim layui-anim-upbit larryTheme-A ">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote mylog-info-tit">
                <div class="layui-inline">
                    <form class="layui-form" id="passRecordSearchForm" style="float: left;margin-right: 20px;">

                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" id="DoorName" name="DoorName" value="" placeholder="请输入岗亭名称" class="layui-input search_input">
                        </div>
                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" id="Name" name="Name" value="" placeholder="请输入工厂名称" class="layui-input search_input">
                        </div>

                        <a class="layui-btn userSearchList_btn" lay-submit lay-filter="userSearchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                        <a class="layui-btn clearDateList_btn" lay-submit lay-filter="clearDateFilter"><i class="layui-icon larry-icon larry-chaxun14"></i>清空</a>

                    </form>

                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-normal userAdd_btn"> <i class="layui-icon larry-icon larry-xinzeng1"></i>新增岗亭</a>
                    </div>

            </blockquote>
            <div class="larry-separate"></div>
            <!-- 用户列表 -->
            <div class="layui-tab-item layui-show " style="padding: 10px 15px;">
                <table id="userTableList"  lay-filter="userTableId" ></table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var $;
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form', 'table', 'layer','common','laydate'], function () {
         $ =  layui.$;
                var form = layui.form,
                table = layui.table,
                layer = layui.layer,
                laydate = layui.laydate;
                common = layui.common;

        var loading = layer.load(0,{ shade: [0.3,'#000']});

        /**用户表格加载*/
        table.render({
            elem: '#userTableList',
            url: '${ctx}/passDoor/passDoorList.do',
            id:'userTableId',
            method: 'post',
            height:'full-140',
            skin:'row',
            even:'true',
            size: 'sm',
            cols: [[
//                {type:"checkbox"},
                {field:'DoorName', title: '岗亭名称',align:'center'},
                {field:'Name', title: '所属工厂',align:'center'},
                {field:'Address', title: '地址',align:'center'},
                {title: '操作', align:'center', width: '17%',toolbar: '#userBar'}
            ]],
            page: true,
            done: function (res, curr, count) {
                common.resizeGrid();
                layer.close(loading);

            }
        });

        /**查询*/
        $(".userSearchList_btn").click(function(){

            var loading = layer.load(0,{ shade: [0.3,'#000000']});
            //监听提交
            form.on('submit(userSearchFilter)', function (data) {
                table.reload('userTableId',{
                    where: {
                            Name:data.field.Name,
                            DoorName:data.field.DoorName,
                    },
                    height: 'full-140',
                    page: true,
                    done: function (res, curr, count) {
                        common.resizeGrid();
                        layer.close(loading);

                    }
                });
            });
        });

        /**清空数据*/
        $(".clearDateList_btn").click(function(){

            $("#Name").val("");
            $("#DoorName").val("");

        });
        /**新增部门*/
        $(".userAdd_btn").click(function(){
            var url = "${ctx}/passDoor/passDoor_add.do";
            common.cmsLayOpen('新增部门',url,'550px','265px');
        });


        /**监听工具条*/
        table.on('tool(userTableId)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var id = data.Id;

            debugger;
            //修改
            if(layEvent === 'user_edit') {
                var url =  "${ctx}/passDoor/passDoor_update.do?id="+id;
                common.cmsLayOpen('编辑',url,'550px','265px');

            }else if(layEvent === 'user_delete'){
                var url = "${ctx}/passDoor/passDoor_delete.do";
                var param = {id:id};
                common.ajaxCmsConfirm('系统提示', '确定删除这条数据吗?',url,param);
            }
        });


    });
</script>
<!-- 用户状态tpl-->
<script type="text/html" id="userStatusTpl">

    {{# if(d.userStatus == 0){ }}
    <span style="color:#5FB878;font-weight:bold"> 0-有效</span>
    {{# } else if(d.userStatus == 1){ }}
    <span style="color:#FF5722;font-weight:bold"> 1-失效</span>

    {{# } else { }}
    {{d.userStatus}}
    {{# }  }}

</script>

<!--工具条 -->
<script type="text/html" id="userBar">
    <div class="layui-btn-group">
        <a class="layui-btn layui-btn-xs user_edit" lay-event="user_edit"><i class="layui-icon larry-icon larry-bianji2"></i> 编辑</a>
        <a class="layui-btn layui-btn-xs user_delete" lay-event="user_delete"><i class="layui-icon larry-icon larry-bianji2"></i> 删除</a>
    </div>
</script>


</body>
</html>