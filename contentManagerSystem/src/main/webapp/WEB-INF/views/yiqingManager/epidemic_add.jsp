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
	        <label class="layui-form-label">单位</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="company" name="company" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位">
	        </div>
	        <label class="layui-form-label">部门</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="department" name="department" lay-verify="required|name" maxlength="20" value="" placeholder="请输入部门">
	        </div>
	    </div>
	    <div class="layui-inline">
	    	<label class="layui-form-label">姓名</label>
        	<div class="layui-input-inline">
              <select id="name" name="name" lay-filter="factoryFilter" lay-verify="required">
                  <option value="">请选择</option>
                  <c:forEach items="${fList}" var="fac">
                  	<option value="${fac.id}">${fac.name}</option>
				  </c:forEach>
              </select>
        	</div>
        	<label class="layui-form-label">身份证</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="id_card" name="id_card" lay-verify="required|name" maxlength="20" value="" placeholder="请输入身份证">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">户籍地址</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="permanent_address" name="permanent_address" lay-verify="required|name" maxlength="20" value="" placeholder="请输入户籍地址">
	        </div>
	        <label class="layui-form-label">长期居住地</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="address" name="address" lay-verify="required|name" maxlength="20" value="" placeholder="请输入长期居住地址">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">手机号</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="phone_number" name="phone_number" lay-verify="required|name" maxlength="20" value="" placeholder="请输入手机号">
	        </div>
	        <label class="layui-form-label">类别</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="category" name="category" lay-verify="required|name" maxlength="20" value="" placeholder="请输入类别">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">类型</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="type" name="type" lay-verify="required|name" maxlength="20" value="" placeholder="请输入类型">
	        </div>
	        <label class="layui-form-label">身体状况</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="health" name="health" lay-verify="required|name" maxlength="20" value="" placeholder="请输入身体状况">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">目前所在地</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="currentLocation" name="currentLocation" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	        <label class="layui-form-label">放假在家/外出</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">离碚日期</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="company" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	        <label class="layui-form-label">离碚目的地(市内)</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">离碚目的地(市外)</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="company" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	        <label class="layui-form-label">离碚交通工具</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">返渝日期</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="company" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	        <label class="layui-form-label">返渝交通工具</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">接触情况</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="company" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	        <label class="layui-form-label">签字</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="company" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
	        </div>
	    </div>
    </div>
    
    <div class="layui-form-item" style="text-align: center;">
            <button class="layui-btn" lay-submit="" lay-filter="saveEpidemic">保存</button>
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
                url : '${ctx}/epidemic/add.do',
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