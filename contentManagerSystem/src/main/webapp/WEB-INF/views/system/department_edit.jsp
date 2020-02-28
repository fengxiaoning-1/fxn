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
    <input id="id" name="id" type="hidden" value="${department.id}">

    <input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item">
	    <div class="layui-inline">
	        <label class="layui-form-label">部门名称</label>
	        <div class="layui-input-inline">
	            <c:if test="${pageFlag == 'addPage' }">
	             <input type="text" class="layui-input" name="name" lay-verify="required|name" maxlength="20" value="" placeholder="请输入部门名称">
	            </c:if>
	            <c:if test="${pageFlag == 'updatePage' }">
	                <input type="text" class="layui-input" name="name" lay-verify="required|name" maxlength="20"  value="${department.name}" placeholder="请输入部门名称" >
	            </c:if>
	        </div>
	    </div>
	    <div class="layui-inline">
	    	<label class="layui-form-label">所属工厂</label>
        <div class="layui-input-inline">
              <select id="factoryId" name="factoryId" lay-filter="factoryFilter" lay-verify="required">
                  <option value="">请选择</option>
                  <c:forEach items="${fList}" var="fac">
						<option value="${fac.id}">${fac.name}</option>
					</c:forEach>
              </select>
          </div>
	    </div>
	    
    </div>
    <div class="layui-form-item">
	    <div class="layui-inline">
	        <label class="layui-form-label">部门级别</label>
	        <div class="layui-input-inline">
	                <select id="level" name="level" lay-filter="levelFilter" lay-verify="required">
	                    <option value="">请选择</option>
	                    <option value="1">一级部门</option>
	                    <option value="2">二级部门</option>
	                </select>
	            </div>
	    </div>
	    <div class="layui-inline">
		    <label class="layui-form-label">部门列表</label>
	        <div class="layui-input-inline">
	             <select id="parentId" name="parentId" lay-filter="departmentIdFilter">
	                 <option value="">请选择</option>
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
        
        function init(){
              //所属工厂不能修改
              var factoryId = ${department.factoryId};
              $("#factoryId option[value='"+factoryId+"']").prop("selected","selected");
              $("#factoryId").attr("disabled","disabled");
              var level = ${department.level};
              $("#level option[value='"+level+"']").prop("selected","selected");
              $("#level").attr("disabled","disabled");
             loadParentMenu();
        }

        /**表单验证*/
        form.verify({
            name: function(value, item){
                //验证部门名
                if(!new RegExp("^([\u4e00-\u9fa5]){2,20}$").test(value)){
                    return '部门姓名只能为中文，长度2-10位';
                }
            }
        });
        /**加载父级菜单*/
        function loadParentMenu(){
            var level =  $("#level option:selected").val();
            var id = $("#id").val();

            if(level != "" && level != "" ){
            	if(level>1){
            		level = level-1;
            	}else{
            		//1级部门、父级部门为空
                    if(level == 1){
                        $('#parentId option').not(":first").remove();
                        form.render('select');
                        return;
                    }	
            	}
                
                //加载父级菜单
                $.ajax({
                    url : '${ctx}/department/ajax_department_parent_menu.do',
                    type : 'post',
                    async: false,
                    data : {
                        level:level,
                        id:id
                    },
                    success : function(data) {
                        if(data != "" ){
                            $('#parentId option').not(":first").remove();
                            $(JSON.parse(data)).each(function(index,item){
                                $("#parentId").append(
                                        '<option value="'+item.id+'">'+item.name+'</option>'
                                );


                            });

                        }
                    }
                });
                form.render('select');

            }
        }


        /**保存*/
        form.on("submit(saveDepartment)",function(data){
            var pageFlag = $("#pageFlag").val();
            var departmentSaveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            //登陆验证
            $.ajax({
                url : '${ctx}/department/ajax_save_department.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    if(data.returnCode == 0000){
                        top.layer.close(departmentSaveLoading);
                        if(pageFlag == 'addPage'){
                            common.cmsLaySucMsg("保存成功,默认密码123456,请及时修改")
                        }else {
                            common.cmsLaySucMsg("保存成功")
                        }
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
        init();
    });

</script>
</body>
</html>