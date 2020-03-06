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
	<input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item">
	    <div class="layui-inline">
	        <label class="layui-form-label">姓名</label>
	        <div class="layui-input-inline">
	             <input type="text" class="layui-input" id="DoorName" name="DoorName" lay-verify="required|name" maxlength="20" value="" placeholder="请输入岗亭名称">
	        </div>
	    </div>
	    <div class="layui-inline">
	    	<label class="layui-form-label">工厂名称</label>
            <div class="layui-input-inline">
              <select id="Id" name="Id" lay-filter="factoryFilter" lay-verify="required">
                  <option value="">请选择</option>
                  <c:forEach items="${fList}" var="fac">
						<option value="${fac.id}">${fac.name}</option>
					</c:forEach>
              </select>
          </div>
	    </div>
        <div class="layui-inline">
            <label class="layui-form-label">所在角色</label>
            <div class="layui-input-inline">
                <select id="roleCode" name="roleCode" lay-filter="factoryFilter" lay-verify="required">
                    <option value="">请选择</option>
                        <option value="admin">管理员</option>
                        <option value="sentry">执勤员</option>
                        <option value="passerby">通勤人员通行</option>
                        <option value="visitor">访客</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">是否检查</label>
            <div class="layui-input-inline">
                <select id="isCheck" name="isCheck" lay-filter="factoryFilter" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="0">未检查</option>
                    <option value="1">已检查</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">通行码</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="passCode" name="passCode" lay-verify="required|name" maxlength="20" value="" readonly>
            </div>
            <button type="button" class="btn btn-primary" id="bt4Pwd" style="width:80px;height:34px;background:#1E8BCC;">随机生成</button>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">通行码有效时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" readonly id="PassCodeValidDate" name="PassCodeValidDate" lay-verify="required|name" maxlength="20" value="" placeholder="请输入时间">
            </div>
        </div><div class="layui-inline">
        <label class="layui-form-label">单位名称</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="companyName" name="companyName" lay-verify="required|name" maxlength="20" value="" placeholder="请输入单位名称">
        </div>
    </div><div class="layui-inline">
        <label class="layui-form-label">所属部门</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="deptName" name="deptName" lay-verify="required|name" maxlength="20" value="" placeholder="请输入所属部门">
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
                laydate = layui.laydate,
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

        //请求时间
        laydate.render({
            elem: '#PassCodeValidDate',
            theme: 'molv',
            value: new Date()
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

        //随机数生成,蓝牙4.0连接密钥
        $("#bt4Pwd").click(function(){
            $("#passCode").val("");
            $("#passCode").val(genStr());  //调用genStr方法
        });

        //获取随机的33位数字和小写字母
        function genStr(){
            var data=["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];

            var result="";
            for(var i=0;i<32;i++){
                var r=Math.floor(Math.random()*36);		//取得0-62间的随机数，目的是以此当下标取数组data里的值！
                result+=data[r];		//输出20次随机数的同时，让rrr加20次，就是20位的随机字符串了。
            }

            debugger;
            return result;
        };
    });

</script>
</body>
</html>