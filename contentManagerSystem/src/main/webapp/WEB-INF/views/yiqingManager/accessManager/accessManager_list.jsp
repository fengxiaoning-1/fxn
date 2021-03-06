<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>绿洲防疫后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="绿洲防疫后台管理系统">
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
                    <form class="layui-form" id="userSearchForm">

                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" id="TrueName" name="TrueName" value="" placeholder="请输入姓名" class="layui-input search_input">
                        </div>
                        <a class="layui-btn userSearchList_btn" lay-submit lay-filter="userSearchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                        <a class="layui-btn clearDateList_btn" lay-submit lay-filter="clearDateFilter"><i class="layui-icon larry-icon larry-chaxun14"></i>清空</a>
                    </form>
                </div>
                <shiro:hasPermission name="0rbT8t2P">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-normal userAdd_btn"> <i class="layui-icon larry-icon larry-xinzeng1"></i>新增</a>
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
    }).use(['form', 'table', 'layer','common'], function () {
         $ =  layui.$;
                var form = layui.form,
                table = layui.table,
                layer = layui.layer,
                common = layui.common;

        var loading = layer.load(0,{ shade: [0.3,'#000']});
        /**用户表格加载*/
        table.render({
            elem: '#userTableList',
            url: '${ctx}/accessManager/accessManagerList.do',
            id:'userTableId',
            method: 'post',
            height:'full-140',
            skin:'row',
            even:'true',
            size: 'sm',
            cols: [[
                /*{type:"checkbox"},*/
                {field:'TrueName', title: '姓名',align:'center' },
                {field:'ParkName', title: '工厂名称',align:'center'},
                {field:'RoleCode', title: '所在角色',align:'center'},
                {field:'IsCheck', title: '是否检查',align:'center'},
                {field:'PassCode', title: '通行码',align:'center',width: '12%'},
                {field:'PassCodeValidDate', title: '通行码有效时间',align:'center'},
                {field:'companyName', title: '单位名称',align:'center'},
                {field:'deptName', title: '所属部门',align:'center'},
                {title: '操作', align:'center', width: '17%',toolbar: '#userBar'}
            ]],
            page: true,
            done: function (res, curr, count) {
                common.resizeGrid();
                layer.close(loading);

            }
        });

        /**清空数据*/
        $(".clearDateList_btn").click(function(){

            $("#TrueName").val("");
        });

        /**查询*/
        $(".userSearchList_btn").click(function(){

            debugger
            var loading = layer.load(0,{ shade: [0.3,'#000000']});
            //监听提交
            form.on('submit(userSearchFilter)', function (data) {
                table.reload('userTableId',{
                    where: {
                              TrueName:data.field.TrueName
                          //  searchContent:data.field.searchContent
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

        /**新增部门*/
        $(".userAdd_btn").click(function(){
            var url = "${ctx}/accessManager/accessManager_add.do";
            common.cmsLayOpen('新增',url,'550px','265px');
        });

        /**导出用户信息*/
        $(".excelUserExport_btn").click(function(){
            var url = '${ctx}/user/excel_users_export.do';
            $("#userSearchForm").attr("action",url);
            $("#userSearchForm").submit();
        });
        /**批量失效*/
        $(".userBatchFail_btn").click(function(){

            //表格行操作
            var checkStatus = table.checkStatus('userTableId');
            if(checkStatus.data.length == 0){
                common.cmsLayErrorMsg("请选择要失效的用户信息");
            }else{
                var isCreateBy = false;
                var userStatus = false;
                var currentUserName = '${LOGIN_NAME.userId}';
                var userIds = [];

                $(checkStatus.data).each(function(index,item){
                    userIds.push(item.userId);
                    //不能失效当前登录用户
                    if(currentUserName != item.userId){
                        isCreateBy = true;
                    }else{
                        isCreateBy = false;
                        return false;
                    }
                    //用户已失效
                    if(item.userStatus == 0){
                        userStatus = true;
                    }else{
                        userStatus = false;
                        return false;
                    }

                });

                if(isCreateBy==false){
                    common.cmsLayErrorMsg("当前登录用户不能被失效,请重新选择");

                    return false;
                }
                if(userStatus==false){
                    common.cmsLayErrorMsg("当前选择的用户已失效");
                    return false;
                }

                var url = "${ctx}/user/ajax_user_batch_fail.do";
                var param = {userIds:userIds};
                common.ajaxCmsConfirm('系统提示', '确定失效当前用户，并解除与角色绑定关系吗?',url,param);

            }

        });

        /**监听工具条*/
        table.on('tool(userTableId)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值

            //修改用户
            if(layEvent === 'user_edit') {
                var userId = data.userId;
                var url =  "${ctx}/user/user_update.do?userId="+userId;
                common.cmsLayOpen('编辑用户',url,'550px','265px');

            //分配角色
            }else if(layEvent === 'user_grant'){
                var userId = data.userId;
                var userStatus = data.userStatus;
                if(userStatus == 1){
                    common.cmsLayErrorMsg("当前用户已失效,不能被分配角色");
                    return false;
                }
                var url =  "${ctx}/user/user_grant.do?userId="+userId;
                common.cmsLayOpen('分配角色',url,'500px','440px');

            //用户失效
            }else if(layEvent === 'user_fail') {
                var userId = data.userId;
                var userStatus = data.userStatus;
                var currentUserId = '${LOGIN_NAME.userId}';/*当前登录用户的ID*/
                if(userStatus == 1){
                    common.cmsLayErrorMsg("当前用户已失效");
                    return false;
                }
                if(userId == currentUserId){
                    common.cmsLayErrorMsg("当前登陆用户不能被失效");
                    return false;
                }

                var url = "${ctx}/user/ajax_user_fail.do";
                var param = {userId:userId};
                common.ajaxCmsConfirm('系统提示', '确定失效用户，并解除与角色绑定关系吗?',url,param);

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