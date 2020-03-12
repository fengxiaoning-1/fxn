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

    <script src="${ctx}/static/layui_v2/layui.js"></script>

</head>
<body class="childrenBody" style="font-size: 12px;margin: 10px 10px 0;">
<form class="layui-form layui-form-pane" method="post" enctype="multipart/form-data">
    <%--<input id="id" name="id" type="hidden" value="${department.id}">--%>
	<input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item" align="center">
	    <div class="layui-inline">
	        <label class="layui-form-label">选择工厂</label>
	        <div class="layui-input-inline">
	        	<select id="parkId" name="park" lay-filter="factoryFilter" lay-verify="required" lay-search>
	        		<option value="" selected="selected">请选择</option>
	        		<option value="23">力帆汽车二工厂</option>
	        		<option value="19">力帆汽车三工厂</option>
	        		<option value="22">试用工厂</option>
	        	</select>
	        </div>
	    </div>
    </div>
    
    <div class="layui-form-item" style="text-align: center;">
            <button type="button" class="layui-btn" id='import'>选择文件</button>
    </div>
    
    <div class="layui-form-item" style="text-align: right;">
            <button type="button" class="layui-btn" lay-filter="aaa" id='importBtn'>导入</button>
    </div>
</form>
<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form','layer','jquery','common','upload'],function(){
        var $ = layui.jquery,
                form = layui.form,
                common = layui.common,
                layer = parent.layer === undefined ? layui.layer : parent.layer,
        		upload = layui.upload;
        
        upload.render({
            elem: '#import'
            ,url: '${ctx}/epidemic/uploadEpidemicXls.do' //改成您自己的上传接口
            ,accept: 'file'
            ,auto: false
            ,field: 'file'
			,bindAction: '#importBtn'
            ,data: {
				parkId: function(){
				    return $("#parkId").find("option:selected").val();;
				},
		        parkName: function(){
		            return $("#parkId").find("option:selected").text();;
		        }
			}
            ,done: function(res){
              //layer.msg('上传成功');
              //console.log(res)
            }
          });
       	
        /**表单验证*/
        form.verify({
            park: function(value){
                //验证部门名
                if(value == ""){
                    return '请选择工厂';
                }
            }
        });

        
        /**保存*/
        form.on("(factoryFilter)",function(data){
        	parkId = data.value;
        	 
        	parkName = data.elem[data.elem.selectedIndex].text;
       	 
       		form.render('select')

        });

        //取消
        /* $("#cancle").click(function(){
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        }); */
    });

</script>
</body>
</html>