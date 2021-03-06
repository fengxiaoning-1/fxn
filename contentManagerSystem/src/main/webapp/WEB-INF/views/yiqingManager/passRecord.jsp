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
                            <input type="text" id="company" name="company" value="" placeholder="请输入单位" class="layui-input search_input">
                        </div>
                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" id="department" name="department" value="" placeholder="请输入部门" class="layui-input search_input">
                        </div>
                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" id="PassTrueName" name="PassTrueName" value="" placeholder="请输入用户姓名" class="layui-input search_input">
                        </div>
                        <div class="layui-input-inline" style="width:300px;">
                            <input type="text" id="PassDate" name="PassDate" placeholder="请输入出入时间" readonly class="layui-input">
                        </div>
                        <a class="layui-btn userSearchList_btn" lay-submit lay-filter="userSearchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                        <a class="layui-btn clearDateList_btn" lay-submit lay-filter="clearDateFilter"><i class="layui-icon larry-icon larry-chaxun14"></i>清空</a>

                    </form>

                    <shiro:hasPermission name="0jOfTHGx">
                        <div class="layui-inline">
                            <a class="layui-btn layui-btn-normal excelUserExport_btn"  style="background-color:#5FB878"> <i class="layui-icon larry-icon larry-danye"></i>导出</a>
                        </div>
                    </shiro:hasPermission>

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

        /**请求时间*/
//        laydate.render({
//            elem: '#PassDate',
//            theme: 'molv',
//            value: new Date()
//        });
        //日期时间范围
        laydate.render({
            elem: '#PassDate'
            ,type: 'datetime'
            ,range: true
        });
        var loading = layer.load(0,{ shade: [0.3,'#000']});

        /**用户表格加载*/
        table.render({
            elem: '#userTableList',
            url: '${ctx}/passRecord/passRecordList.do',
            id:'userTableId',
            method: 'post',
            height:'full-140',
            skin:'row',
            even:'true',
            size: 'sm',
            cols: [[
                /*{type:"checkbox"},*/
                {field:'ParkName', title: '工厂',align:'center'},
                {field:'company', title: '单位',align:'center'},
                {field:'department', title: '部门',align:'center'},
                {field:'PassTrueName', title: '用户姓名',align:'center',width: '12%'},
                {field:'PhoneNumber', title: '联系方式',align:'center'},
                {field:'PassDate', title: '出入时间',align:'center'},
                {field:'DoorName', title: '岗亭',align:'center'},
                {field:'IsIn', title: '出入状态',align:'center'},
                {field:'Temperature', title: '体温',align:'center'},
                {field:'Admit', title: '是否通过',align:'center'},
                /* {field:'updateTime', title: '修改时间',align:'center',width: '12%'},*/
               /* {title: '操作', align:'center', width: '17%',toolbar: '#userBar'}*/
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
                            PassTrueName:data.field.PassTrueName,
                            PassDate:data.field.PassDate,
                            company:data.field.company,
                            department:data.field.department
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

            $("#PassTrueName").val("");
            $("#PassDate").val("");
            $("#company").val("");
            $("#department").val("");
        });

       

        /**导出出入记录信息*/
        $(".excelUserExport_btn").click(function(){
            var url = '${ctx}/passRecord/excel_passRecord_export.do';
            $("#passRecordSearchForm").attr("action",url);
            $("#passRecordSearchForm").submit();
        });
        
        /**监听工具条*/
        table.on('tool(userTableId)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值

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
        <shiro:hasPermission name="fSv1B2kZ">
            <a class="layui-btn layui-btn-xs user_edit" lay-event="user_edit"><i class="layui-icon larry-icon larry-bianji2"></i> 编辑</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="mScICO9G">
            <a class="layui-btn layui-btn-xs layui-btn-warm  user_grant" lay-event="user_grant"><i class="layui-icon larry-icon larry-jiaoseguanli3"></i>角色</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="uBg9TdEr">
            <a class="layui-btn layui-btn-xs layui-btn-danger user_fail" lay-event="user_fail"><i class="layui-icon larry-icon larry-ttpodicon"></i>失效</a>
        </shiro:hasPermission>
    </div>
</script>


</body>
</html>