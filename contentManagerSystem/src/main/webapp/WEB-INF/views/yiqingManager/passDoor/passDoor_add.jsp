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
<form class="layui-form layui-form-pane">
    <%--<input id="id" name="id" type="hidden" value="${department.id}">--%>
	<input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item">
	    <div class="layui-inline">
	        <label class="layui-form-label">岗亭名称</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="DoorName" lay-verify="required|name" maxlength="20" value="" placeholder="请输入岗亭名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	    	<label class="layui-form-label">所属工厂</label>
        <div class="layui-input-inline">
              <select id="Id" name="Id" lay-filter="factoryFilter" lay-verify="required">
                  <option value="">请选择</option>
                  <c:forEach items="${fList}" var="fac">
						<option value="${fac.id}">${fac.name}</option>
					</c:forEach>
              </select>
          </div>
	    </div>
	    
    </div>
    
    <div class="layui-form-item" style="text-align: center;">
            <button class="layui-btn" lay-submit="" lay-filter="saveDepartment">保存</button>
            <button type="layui-btn" id="cancle" class="layui-btn layui-btn-primary">取消</button>
    </div>
</form>
<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form','layer','jquery','common'],function(){
        var $ = layui.$,
                form = layui.form,
                common = layui.common,
                layer = parent.layer === undefined ? layui.layer : parent.layer;
        

        /**表单验证*/
        form.verify({
            name: function(value, item){
                //验证部门名
                if(!new RegExp("^([\u4e00-\u9fa5]){2,20}$").test(value)){
                    return '部门姓名只能为中文，长度2-10位';
                }
            }
        });

        /**保存*/
        form.on("submit(saveDepartment)",function(data){
            var pageFlag = $("#pageFlag").val();
            var departmentSaveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            //登陆验证
            $.ajax({
                url : '${ctx}/passDoor/passDoor_addSave.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {

                    if(data == "true"){
                        top.layer.close(departmentSaveLoading);
                        common.cmsLaySucMsg("保存成功")
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }else{
                        top.layer.close(departmentSaveLoading);
                        common.cmsLayErrorMsg(data.returnMessage);
                    }
                },error:function(data){
                    top.layer.close(index);

                }
            });
            return false;
        });

        //取消
        $("#cancle").click(function(){
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });
    });

</script>
</body>
</html>