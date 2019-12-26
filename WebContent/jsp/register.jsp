<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/Resource/images/headlogo.png" />
<!-- 给网页标题前加一个小图标-->
<title>电子商务系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resource/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resource/css/style.css"
	type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<%@include file="/jsp/head.jsp"%>
	<!-- 静态包含：将所有内容包含进来 -->

	<div class="container"
		style="width:100%;background:url('${pageContext.request.contextPath}/Resource/image/regist_bg.jpg');">
		<div class="row">

			<div class="col-md-2"></div>

			<div class="col-md-8"
				style="background: rgba(245, 245, 220, 0.5); padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" method="post"
					action="${pageContext.request.contextPath }/user" onsubmit="return check(this);">
					<input type="hidden" name="method" value="regist">

					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="account"
								placeholder="请输入用户名" name="account">
						</div>
						<label id="accountError" style="color: red"></label>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password"
								placeholder="请输入密码" name="password">
						</div>
						<label id="passwordError" style="color: red"></label>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd"
								placeholder="请输入确认密码">
						</div>
						<label id="confirmpwdError" style="color: red"></label>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email"
								placeholder="Email" name="email">
						</div>
						<label id="emailError" style="color: red"></label>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name"
								placeholder="请输入姓名" name="name">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sex1" value="1"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="sex2" value="0"> 女
							</label>
						</div>
						<label id="sexError" style="color: red"></label>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" id="birthday" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								border="0"
								style="background: url('${pageContext.request.contextPath}/Resource/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<div style="margin-top: 50px;">
		<img
			src="${pageContext.request.contextPath}/Resource/image/footer.jpg"
			width="100%" height="78" alt="我们的优势" title="我们的优势" />
	</div>

	<div style="text-align: center; margin-top: 5px;">
		<ul class="list-inline">
			<li><a href="${pageContext.request.contextPath}/jsp/info.jsp">关于我们</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/contact.jsp">联系我们</a></li>
			<li><a href="javascript:void(0)">招贤纳士</a></li>
			<li><a href="javascript:void(0)">法律声明</a></li>
			<li><a href="javascript:void(0)">友情链接</a></li>
			<li><a href="javascript:void(0)">支付方式</a></li>
			<li><a href="javascript:void(0)">配送方式</a></li>
			<li><a href="javascript:void(0)">服务声明</a></li>
			<li><a href="javascript:void(0)">广告声明</a></li>
		</ul>
	</div>
	<div style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
		Copyright &copy; 电子商务系统 版权所有</div>

</body>
<script type="text/javascript">
var accountFlag=true;
var emailFlag=true;
$(function(){
	
	$('#account').blur(function(){
		var account=$('#account').val();
		if (account!="") {
			/* 唯一值判断 */
			$.post(
					"${pageContext.request.contextPath}/user",
					{
						"method" : "verifyAccount","account":account
					},
					function(obj) {
						if (obj=="not null") {
							$('#accountError').html("该用户名已存在");
							accountFlag=false;
						}
						if (obj=="null") {
							$('#accountError').html("");
							accountFlag=true;
						}
					}
			);
		}
	});
	
	$('#confirmpwd').blur(function(){
		if($('#password').val()!=$('#confirmpwd').val()) {
			$('#confirmpwdError').html("密码不一致");
		}else {
			$('#confirmpwdError').html("");
		}
	});
	
	$('#email').blur(function(){
		var emailPattern=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
		var email=$('#email').val();
		
		if(email!="") {	
			if (emailPattern.test(email)) {
				$('#emailError').html("");
				/* 唯一值判断 */
				 $.post(
						"${pageContext.request.contextPath}/user",
						{
							"method" : "verifyEmail","email":email
						},
						function(obj) {
							if (obj=="not null") {
								$('#emailError').html("该邮箱已注册");
								emailFlag=false;
							}
							if (obj=="null") {
								$('#emailError').html("");
								emailFlag=true;
							}
						}
				);
			} else{
				$('#emailError').html("邮箱格式不正确");
				emailFlag=false;
			}
		}
	});
	
});

function check(form) {
	with(form) {
		var sexFlag=false;
		var sex=document.getElementsByName("sex");
		
		if ($('#account').val()=="") {
			$('#accountError').html("用户名不能为空");
			return false;
		}else{
			$('#accountError').html("");
		}

		if (accountFlag==false){
			$('#accountError').html("该用户名已存在");
			return false;
		}else{
			$('#accountError').html("");
		}
			
		if (emailFlag==false){
			$('#emailError').html("该邮箱已注册");
			return false;
		}else{
			$('#accountError').html("");
		}
		
		if ($('#password').val()=="") {
			$('#passwordError').html("密码不能为空");
			return false;
		}else{
			$('#passwordError').html("");
		}
		
		if ($('#confirmpwd').val()=="") {
			$('#confirmpwdError').html("确认密码不能为空");
			return false;
		}else{
			$('#confirmpwdError').html("");
		}
		
		if($('#password').val()!=$('#confirmpwd').val()) {
			$('#confirmpwdError').html("密码不一致");
			return false;
		}else{
			$('#confirmpwdError').html("");
		}
		
		for(var i=0;i<sex.length;i++){
			if (sex[i].checked==true) {
				sexFlag=true;
			}
		}
		if (sexFlag==false) {
			$('#sexError').html("请选择性别");
			return false;
		}else{
			$('#sexError').html("");
		}
		
		if($('#email').val()=="") {
			$('#emailError').html("邮箱不能为空");
			return false;
		}else{
			$('#emailError').html("");
		}
		
	}
}
</script>
</html>




