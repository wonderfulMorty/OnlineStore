<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
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
</head>

<body>
	<div class="container-fluid">

		<%@include file="/jsp/head.jsp"%>
		<!-- 静态包含：将所有内容包含进来 -->

		<div class="container-fluid">
			<div class="main_con">
				<h2>关于我们</h2>
				<hr />
				<div>
					<p style="font-family: 华文行楷; font-size: large;">
						&nbsp;&nbsp;&nbsp;&nbsp;我什么都做不到，一个人的话什么都做不到。但我也因此隐约发现了，能让人产生勇气的东西，发现我想保护的人们也在保护我。</p>
					<p style="font-family: 华文行楷; font-size: large;">
						&nbsp;&nbsp;&nbsp;&nbsp;感受到别人的温柔之后，自己也想变得温柔，就像别人在治愈我一样，我也希望能做点什么。</p>
				</div>
			</div>
		</div>

	</div>
	<div class="container-fluid">
		<div style="margin-top: 50px;">
			<img src="${pageContext.request.contextPath}/Resource/img/footer.jpg"
				width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center; margin-top: 5px;">
			<ul class="list-inline">
				<li>关于我们</li>
				<li><a
					href="${pageContext.request.contextPath}/jsp/contact.jsp">联系我们</a></li>
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
	</div>

</body>

</html>