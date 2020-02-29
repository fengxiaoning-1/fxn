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
                    <form class="layui-form" id="userSearchForm">
                        <div class="layui-input-inline" style="width:110px;">
                                	部门名称
                        </div>
                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" name="searchContent" value="" placeholder="请输入查询名称" class="layui-input search_input">
                        </div>
                        <a class="layui-btn userSearchList_btn" lay-submit lay-filter="userSearchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                    </form>
                </div>
                 <div class="layui-inline">
                     <a class="layui-btn layui-btn-normal userAdd_btn"> <i class="layui-icon larry-icon larry-xinzeng1"></i>新增部门</a>
                 </div>

            </blockquote>
            <div class="larry-separate"></div>
            <!-- 部门列表 -->
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
        /**部门表格加载*/
        table.render({
            elem: '#userTableList',
            url: '${ctx}/department/ajax_department_list.do',
            id:'userTableId',
            method: 'post',
            height:'full-140',
            skin:'row',
            even:'true',
            size: 'sm',
            cols: [[
                {type:"checkbox"},
                {field:'name', title: '部门名称',align:'center' },
                {field:'factoryName', title: '所属工厂',align:'center' },
                {field:'level', title: '部门级别',align:'center', templet: '#levelTpl'},
                {field:'creator', title: '创建人',align:'center'},
                {field:'createTime', title: '创建时间',align:'center',width: '12%'},
                {field:'modifier', title: '修改人',align:'center'},
                {field:'modifierTime', title: '修改时间',align:'center',width: '12%'},
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
            var loading = layer.load(0,{ shade: [0.3,'#000']});
            //监听提交
            form.on('submit(userSearchFilter)', function (data) {
                table.reload('userTableId',{
                    where: {
                            searchContent:data.field.searchContent
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
            var url = "${ctx}/department/department_add.do";
            common.cmsLayOpen('新增部门',url,'550px','265px');
        });


        /**监听工具条*/
        table.on('tool(userTableId)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var id = data.id;
            //修改
            if(layEvent === 'user_edit') {
                var url =  "${ctx}/department/department_update.do?id="+id;
                common.cmsLayOpen('编辑',url,'550px','265px');

            }else if(layEvent === 'user_delete'){
            	var url = "${ctx}/department/ajax_delete_department.do";
                var param = {id:id};
                common.ajaxCmsConfirm('系统提示', '确定删除部门吗?',url,param);
            }
        });

    });
</script>


<!--工具条 -->
<script type="text/html" id="userBar">
    <div class="layui-btn-group">
        <a class="layui-btn layui-btn-xs user_edit" lay-event="user_edit"><i class="layui-icon larry-icon larry-bianji2"></i> 编辑</a>
        {{# if(d.level == 2){ }}
		<a class="layui-btn layui-btn-xs user_delete" lay-event="user_delete"><i class="layui-icon larry-icon larry-bianji2"></i> 删除</a>
    	{{#  } }}
	</div>
</script>

<script type="text/html" id="levelTpl">

    {{# if(d.level == 1){ }}
     	一级部门
    {{# } else if(d.level == 2){ }}
   		二级部门
    {{# } else { }}
    	{{d.level}}
    {{# }  }}
</script>


</body>
</html>