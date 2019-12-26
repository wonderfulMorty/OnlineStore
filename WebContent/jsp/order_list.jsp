<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
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
</style>
</head>

<body>

	<%@include file="/jsp/head.jsp"%>
	<!-- 静态包含：将所有内容包含进来 -->

	<div class="container">
		<div class="row">

			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong><hr>
				<table class="table table-bordered">
					<c:forEach items="${orderPageBean.data }" var="order">
						<tbody>
							<tr class="success">
								<!-- colspan： 单元格横跨的列数 -->
								<th colspan="2">订 单 号 :${order.id} </th>
								<th colspan="1">
									<c:if test="${order.state == 0 }"><a href="${pageContext.request.contextPath}/order?method=getProductById&orderId=${order.id}">去付款</a></c:if>
									<c:if test="${order.state == 1 }">已付款</c:if> 
									<c:if test="${order.state == 2 }"><a href="${pageContext.request.contextPath}/order?method=updateState&orderId=${order.id}">确认收货</a></c:if> 
									<c:if test="${order.state == 3 }">已完成</c:if>  
								</th>
								<th colspan="2">金额：${order.total}
								 </th>
							</tr>
							<tr class="warning">
								<th style="font-family: 华文行楷; font-size: larger;">图 片</th>
								<th style="font-family: 华文行楷; font-size: larger;">商 品</th>
								<th style="font-family: 华文行楷; font-size: larger;">价 格</th>
								<th style="font-family: 华文行楷; font-size: larger;">数 量</th>
								<th style="font-family: 华文行楷; font-size: larger;">小 计</th>
							</tr>
							<c:forEach items="${order.items }" var="oi">
								<tr class="active">
									<td width="60" width="40%"><input type="hidden" name="id"
										value="22"> <img
										src="${pageContext.request.contextPath}/${oi.product.image}"
										width="70" height="60"></td>
									<td width="30%"><a target="_blank">${oi.product.product_name}</a></td>
									<td width="20%">￥${oi.product.mall_price}</td>
									<td width="10%">${oi.count}</td>
									<td width="15%"><span class="subtotal">￥${oi.subtotal}</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<%@include file="/jsp/page.jsp" %>
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

</html>