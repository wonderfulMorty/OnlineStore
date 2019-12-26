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


	<div class="container">
		
		<c:if test="${empty cart || empty cart.cartItems }">
			<h2>购物车详情</h2>
			<hr/>
			<h3 style="font-family: 华文行楷">购物车空空如也，亲，逛逛商城添加心仪的商品吧~_~</h3>
		</c:if>
		<c:if test="${not empty cart.cartItems}">
			<div class="row">
				<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
					<strong style="font-size: 16px; margin: 5px 0;">购物车详情</strong><hr>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${cart.cartItems }" var="ci">
								<tr class="active">
									<td width="60" width="40%"><input type="hidden" name="id"
										value="22"> <img
										src="${pageContext.request.contextPath}/${ci.product.image}"
										width="70" height="60"></td>
									<td width="30%"><a target="_blank">${ci.product.product_name}</a>
									</td>
									<td width="20%">￥${ci.product.mall_price}</td>
									<td width="10%"><input type="text" readonly="readonly"
										name="quantity" value="${ci.count }" maxlength="4" size="10">
									</td>
									<td width="15%"><span class="subtotal">￥${ci.subtotal}</span>
									</td>
									<td><a href="javascript:void(0);" class="delete"
										onclick="removeFromCart('${ci.product.id}')">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
		</div>

		<div style="margin-right: 130px;">
			<div style="text-align: right;">
				商品金额: <strong style="color: #ff6600;">￥${cart.total }元</strong>
			</div>
			<div
				style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
				<a href="${pageContext.request.contextPath}/cart?method=clear"
					id="clear" class="clear">清空购物车
				</a> 
				<a href="${pageContext.request.contextPath}/order?method=save"> <input
					type="submit" width="100" value="提交订单" name="submit" border="0"
					style="background: url('${pageContext.request.contextPath}/Resource/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
				</a>
			</div>
		</div>
		</c:if>
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
		function removeFromCart(productId){
			if (confirm("您忍心抛弃我吗？")) {
				location.href="${pageContext.request.contextPath}/cart?method=remove&productId="+productId;
			}
		}
	</script>

</html>